package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.Exceptions.CustomerException;
import com.Model.Transactions;
import com.Utility.DBUtil;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public int LoginCustomer(String email, String password) throws CustomerException {
		int acc = -1;
		String response = "Invalid email or password.";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select name, accountNumber from Customer where email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Welcome " + rs.getString("name") +"!");
				acc = rs.getInt("accountNumber");
			} else {
				throw new CustomerException(response);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return acc;
	}

	@Override
	public int viewBalance(int accountNumber) throws CustomerException {
		int response = -1;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select balance from Customer where accountNumber = ?");
			ps.setInt(1, accountNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				response = rs.getInt("balance");
			} else {
				throw new CustomerException("Invalid Account Number.");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return response;
	}

	@Override
	public int Deposit(int accountNumber, int amount) throws CustomerException {
		int response = -1;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("update Customer set balance = balance+? where accountNumber = ?");
			ps.setInt(1, amount);
			ps.setInt(2, accountNumber);
			int res = ps.executeUpdate();
			
			if(res > 0) {
				PreparedStatement ps2 = con.prepareStatement("insert into transactions(accountNumber, deposit, timeOfTransaction) values(?, ?, NOW())");
				ps2.setInt(1, accountNumber);
				ps2.setInt(2, amount);
				
				int res2 = ps2.executeUpdate();
				if(res2 > 0) {
					PreparedStatement ps3 = con.prepareStatement("select balance from customer where accountNumber= ?");
					ps3.setInt(1, accountNumber);
					ResultSet rs = ps3.executeQuery();
					if(rs.next()) {
						response = rs.getInt("balance");
					} else {
						throw new CustomerException("Transaction could not be completed.");
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response = -1;
		}
		
		return response;
	}

	@Override
	public int withdraw(int accountNumber, int amount) throws CustomerException {
		
		int response = -1;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			int previousBal = viewBalance(accountNumber);
			
			if(amount <= previousBal) {
				PreparedStatement ps = con.prepareStatement("update Customer set balance = balance-? where accountNumber = ?");
				ps.setInt(1, amount);
				ps.setInt(2, accountNumber);
				int res = ps.executeUpdate();
				
				if(res > 0) {
					PreparedStatement ps2 = con.prepareStatement("insert into transactions(accountNumber, withdraw, timeOfTransaction) values(?, ?, NOW())");
					ps2.setInt(1, accountNumber);
					ps2.setInt(2, amount);
					
					int res2 = ps2.executeUpdate();
					if(res2 > 0) {
						PreparedStatement ps3 = con.prepareStatement("select balance from customer where accountNumber= ?");
						ps3.setInt(1, accountNumber);
						ResultSet rs = ps3.executeQuery();
						if(rs.next()) {
							response = rs.getInt("balance");
						} else {
							throw new CustomerException("Transaction could not be completed.");
						}
					}
				}
				
			} else {
				throw new CustomerException("Insufficient Balance");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response = -1;
		}
		
		return response;
		
		
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
	public String transfer(int accountNumber1, int amount, int accountNumber2) throws CustomerException {
		String response = "Invalid account number. ";
		int previousBal = viewBalance(accountNumber1);
		
		if(previousBal >= amount && checkAccount(accountNumber2)) {
			
			int with = withdraw(accountNumber1, amount);
			int dep = Deposit(accountNumber2, amount);
			
			if(with != -1 && dep != -1) {
				response = "New balance = " + with; 
			} else {
				throw new CustomerException(response);
			}
		} else {
			if(checkAccount(accountNumber2) == false) {
				throw new CustomerException(response);
			} else {
				throw new CustomerException("Insufficient Balance.");
			}
		}
		
		
		return response;
	}

	@Override
	public List<Transactions> viewTransaction(int accountNumber) throws CustomerException {
		List<Transactions> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from transactions where accountNumber = ?");
			ps.setInt(1, accountNumber);
			
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
	public int getAccNo(String email) {
		int acc = -1;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select accountNumber from customer where email = ?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				acc = rs.getInt("accountNumber");
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return acc;
	}
	
}
