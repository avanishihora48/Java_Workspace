package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import com.model.InsuranceModel;
import com.model.Model;
import com.model.TransactionModel;
import java.sql.Timestamp;


public class Dao 
{
    public static Connection getconnect()
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen_card_system", "root", "");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return con;
    }

    public static int signupdata(Model m)
    {
        int status = 0;

        Connection con = Dao.getconnect();

        String citizenId = generateCitizenId();
        m.setCitizenId(citizenId); 

        try 
        {
            PreparedStatement ps = con.prepareStatement("INSERT INTO registration(citizenId, fname, lname, gender, email, phone, city, password, repassword) VALUES(?,?,?,?,?,?,?,?,?)");

            ps.setString(1, m.getCitizenId());
            ps.setString(2, m.getFname());
            ps.setString(3, m.getLname());
            ps.setString(4, m.getGender());
            ps.setString(5, m.getEmail());
            ps.setString(6, m.getPhone());
            ps.setString(7, m.getCity());
            ps.setString(8, m.getPassword());
            ps.setString(9, m.getRepassword());

            status = ps.executeUpdate();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return status;
    }

    public static Model signindata(Model m) 
    {
        Connection con = Dao.getconnect();
        Model m2 = null;

        try 
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM registration WHERE email=? AND password=?");

            ps.setString(1, m.getEmail());
            ps.setString(2, m.getPassword());

            ResultSet set = ps.executeQuery();

            if (set.next()) 
            {
                int id = set.getInt("id");
                String citizenId = set.getString("citizenId");
                String fname = set.getString("fname");
                String lname = set.getString("lname");
                String gender = set.getString("gender");
                String email = set.getString("email");
                String phone = set.getString("phone");
                String city = set.getString("city");
                String password = set.getString("password");
                String repassword = set.getString("repassword");

                m2 = new Model();
                m2.setId(id);
                m2.setCitizenId(citizenId);
                m2.setFname(fname);
                m2.setLname(lname);
                m2.setGender(gender);
                m2.setEmail(email);
                m2.setPhone(phone);
                m2.setCity(city);
                m2.setPassword(password);
                m2.setRepassword(repassword);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return m2; 
    }

    public static String generateCitizenId() 
    {
        return "CIT" + UUID.randomUUID().toString().substring(0, 8);  
    }

    public static void saveCitizenId(int userId, String citizenId) 
    {
        Connection con = Dao.getconnect();
        try 
        {
            PreparedStatement ps = con.prepareStatement("UPDATE registration SET citizenId=? WHERE id=?");

            ps.setString(1, citizenId);
            ps.setInt(2, userId);

            ps.executeUpdate();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

	public static int setInsuranceDetails(InsuranceModel im) 
	{
		int status = 0;
		
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("INSERT into insurance(citizenId,policyName,coverageAmount,premiumAmount)values(?,?,?,?)");
			ps.setString(1, im.getCitizenId());
			ps.setString(2, im.getPolicyname());
			ps.setString(3, im.getCoverageAmount());
			ps.setString(4, im.getPremiumAmount());
			
			status = ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static boolean saveDeposit(TransactionModel transaction) {
	    boolean status = false;
	    Connection con = Dao.getconnect();
	    PreparedStatement ps = null;
	    PreparedStatement pstmt = null;

	    try {
	        con.setAutoCommit(false);

	        double balance = getUserBalance(transaction.getCitizenId(), transaction.getBank());

	        if (balance == -1) 
	        {
	            status = insertNewAccount(transaction);
	        } 
	        else 
	        {
	            status = updateUserBalance(transaction.getCitizenId(), transaction.getBank(), balance + transaction.getAmount());
	        }

	        if (status) 
	        {
	            ps = con.prepareStatement("INSERT INTO transactions (citizenId, bank, transactionType, amount, transaction_date) VALUES (?, ?, ?, ?, ?)");
	            ps.setString(1, transaction.getCitizenId());
	            ps.setString(2, transaction.getBank());
	            ps.setString(3, transaction.getTransactionType());
	            ps.setDouble(4, transaction.getAmount());
	            java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
	            ps.setTimestamp(5, timestamp);

	            int rowsAffected = ps.executeUpdate();

	            if (rowsAffected > 0) {
	                con.commit(); 
	                status = true;
	            } else {
	                con.rollback(); 
	                status = false;
	            }
	        }

	    } 
	    catch (SQLException e) 
	    {
	        try {
	            con.rollback(); 
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        try {
	            con.setAutoCommit(true); 
	            if (ps != null) ps.close();
	            if (pstmt != null) pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return status;
	}

	private static boolean insertNewAccount(TransactionModel transaction) 
	{
	    Connection con = Dao.getconnect();
	    PreparedStatement ps = null;
	    boolean status = false;

	    try 
	    {
	        ps = con.prepareStatement("INSERT INTO user_accounts (citizenId, bank, balance) VALUES (?, ?, ?)");
	        ps.setString(1, transaction.getCitizenId());
	        ps.setString(2, transaction.getBank());
	        ps.setDouble(3, transaction.getAmount());  
	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            status = true;
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        try {
	            if (ps != null) ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return status;
	}

	private static boolean updateUserBalance(String citizenId, String bank, double newBalance) 
	{
	    Connection con = Dao.getconnect();
	    PreparedStatement ps = null;
	    boolean status = false;

	    try 
	    {
	        ps = con.prepareStatement("UPDATE user_accounts SET balance = ? WHERE citizenId = ? AND bank = ?");
	        ps.setDouble(1, newBalance);
	        ps.setString(2, citizenId);
	        ps.setString(3, bank);

	        int rows = ps.executeUpdate();
	        if (rows > 0) {
	            status = true;
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        try {
	            if (ps != null) ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return status;
	}

	private static double getUserBalance(String citizenId, String bank) 
	{
	    double balance = -1;
	    Connection con = Dao.getconnect();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try 
	    {
	        ps = con.prepareStatement("SELECT balance FROM user_accounts WHERE citizenId = ? AND bank = ?");
	        ps.setString(1, citizenId);
	        ps.setString(2, bank);
	        rs = ps.executeQuery();

	        if (rs.next()) 
	        {
	            balance = rs.getDouble("balance");
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return balance;
	}

	
	
	public static boolean saveWithdraw(TransactionModel transaction) 
	{
	    boolean status = false;
	    Connection con = Dao.getconnect();

	    try 
	    {
	        con.setAutoCommit(false); 

	        double balance = getUserBalance(transaction.getCitizenId(), transaction.getBank());
	       
	        if (balance >= transaction.getAmount()) 
	        {
	          
	            PreparedStatement ps = con.prepareStatement("INSERT INTO transactions (citizenId, bank, transactionType, amount, transaction_date) VALUES (?, ?, ?, ?, ?)");
	            ps.setString(1, transaction.getCitizenId());
	            ps.setString(2, transaction.getBank());
	            ps.setString(3, transaction.getTransactionType());
	            ps.setDouble(4, transaction.getAmount());
	            java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
	            ps.setTimestamp(5, timestamp);

	            int rowsAffected = ps.executeUpdate();

	            if (rowsAffected > 0) 
	            {
	                updateUserBalance(transaction.getCitizenId(), transaction.getBank(), balance - transaction.getAmount());
	                con.commit();
	                status = true;
	            } 
	            else 
	            { 
	                con.rollback();
	                status = false;
	            }
	        } 
	        else 
	        {
	            status = false; 
	        }
	    } 
	    catch (SQLException e) 
	    {
	        try {
	            con.rollback();  
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        try {
	            con.setAutoCommit(true); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return status;
	}

	public static boolean saveTransfer(TransactionModel transaction, String destinationAccount, String destinationBank) 
	{
	    
		  
		Connection con = Dao.getconnect();
	    PreparedStatement psDebit = null;
	    PreparedStatement psCredit = null;
	    PreparedStatement psCheckRecipient = null;

	    try 
	    {
	        con.setAutoCommit(false);

	        psCheckRecipient = con.prepareStatement("SELECT balance FROM user_accounts WHERE citizenId = ? AND bank = ?");
	        psCheckRecipient.setString(1, destinationAccount);
	        psCheckRecipient.setString(2, destinationBank);

	        ResultSet rs = psCheckRecipient.executeQuery();
	        if (!rs.next()) {
	            System.out.println("Recipient account not found: " + destinationAccount + " at bank: " + destinationBank);
	            con.rollback();
	            return false;
	        }

	        psDebit = con.prepareStatement("UPDATE user_accounts SET balance = balance - ? WHERE citizenId = ? AND bank = ? AND balance >= ?");
	        psDebit.setDouble(1, transaction.getAmount());
	        psDebit.setString(2, transaction.getCitizenId());
	        psDebit.setString(3, transaction.getBank());
	        psDebit.setDouble(4, transaction.getAmount());

	        int rowsDebited = psDebit.executeUpdate();
	        if (rowsDebited == 0) 
	        {
	            System.out.println("Insufficient balance or sender account not found: " + transaction.getCitizenId());
	            con.rollback();
	            return false;
	        }

	        psCredit = con.prepareStatement("UPDATE user_accounts SET balance = balance + ? WHERE citizenId = ? AND bank = ?");
	        psCredit.setDouble(1, transaction.getAmount());
	        psCredit.setString(2, destinationAccount);
	        psCredit.setString(3, destinationBank);

	        int rowsCredited = psCredit.executeUpdate();
	        if (rowsCredited == 0) 
	        {
	            con.rollback();
	            return false;
	        }

	        PreparedStatement psTransaction = con.prepareStatement("INSERT INTO transactions (citizenId, bank, transactionType, amount, transaction_date) VALUES (?, ?, ?, ?, ?)");
	        psTransaction.setString(1, transaction.getCitizenId());
	        psTransaction.setString(2, transaction.getBank());
	        psTransaction.setString(3, "Transfer to " + destinationAccount);
	        psTransaction.setDouble(4, transaction.getAmount());
	        psTransaction.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
	        psTransaction.executeUpdate();

	        PreparedStatement psRecipientTransaction = con.prepareStatement("INSERT INTO transactions (citizenId, bank, transactionType, amount, transaction_date) VALUES (?, ?, ?, ?, ?)");
	        psRecipientTransaction.setString(1, destinationAccount);
	        psRecipientTransaction.setString(2, destinationBank);
	        psRecipientTransaction.setString(3, "Transfer from " + transaction.getCitizenId());
	        psRecipientTransaction.setDouble(4, transaction.getAmount());
	        psRecipientTransaction.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
	        psRecipientTransaction.executeUpdate();

	        con.commit();
	        return true;

	    } 
	    catch (SQLException e) 
	    {
	        try {
	            if (con != null) con.rollback();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        try {
	            if (psDebit != null) psDebit.close();
	            if (psCredit != null) psCredit.close();
	            if (psCheckRecipient != null) psCheckRecipient.close();
	            if (con != null) con.setAutoCommit(true);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}


}
