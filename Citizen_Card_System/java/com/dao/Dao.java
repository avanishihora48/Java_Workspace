package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.model.GasModel;
import com.model.InsuranceModel;
import com.model.Model;
import com.model.TaxModel;
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

    public static int signupdata(Model m) {
        int status = 0;

        Connection con = Dao.getconnect();

        String citizenId = generateCitizenId();
        m.setCitizenId(citizenId);

        String gasNumber = generateGasNumber();
        m.setGasNumber(gasNumber);
        
        String vehicleRegistrationNo = generateVRNo();
        m.setVehicleRegistrationNo(vehicleRegistrationNo);
        
        String engineNumber = generateEngineNo();
        m.setEngineNumber(engineNumber);
        
        String electricityNumber = generateENo();
        m.setElectricityNumber(electricityNumber);
        
        String passportNumber = generatePassNo();
        m.setPassportNumber(passportNumber);
        
        try {
        	PreparedStatement ps = con.prepareStatement("INSERT INTO registration(citizenId, fname, lname, gender, email, phone, city, password, gasNumber, vehicleRegistrationNo, engineNumber, electricityNumber, passportNumber) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, m.getCitizenId());
            ps.setString(2, m.getFname());
            ps.setString(3, m.getLname());
            ps.setString(4, m.getGender());
            ps.setString(5, m.getEmail());
            ps.setString(6, m.getPhone());
            ps.setString(7, m.getCity());
            ps.setString(8, m.getPassword());
            ps.setString(9, m.getGasNumber()); 
            ps.setString(10, m.getVehicleRegistrationNo());
            ps.setString(11, m.getEngineNumber());
            ps.setString(12, m.getElectricityNumber());
            ps.setString(13, m.getPassportNumber());

            status = ps.executeUpdate();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return status;
    }

	public static Model signindata(Model m) {
        Connection con = Dao.getconnect();
        Model m2 = null;

        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM registration WHERE email=? AND password=?")) {
            ps.setString(1, m.getEmail());
            ps.setString(2, m.getPassword()); 

            try (ResultSet set = ps.executeQuery()) {
                if (set.next()) {
                    m2 = new Model();
                    m2.setId(set.getInt("id"));
                    m2.setCitizenId(set.getString("citizenId"));
                    m2.setFname(set.getString("fname"));
                    m2.setLname(set.getString("lname"));
                    m2.setGender(set.getString("gender"));
                    m2.setEmail(set.getString("email"));
                    m2.setPhone(set.getString("phone"));
                    m2.setCity(set.getString("city"));
                    m2.setPassword(set.getString("password"));
                    m2.setGasNumber(set.getString("gasNumber"));
                    m2.setVehicleRegistrationNo(set.getString("vehicleRegistrationNo"));
                    m2.setEngineNumber(set.getString("engineNumber"));
                    m2.setElectricityNumber(set.getString("electricityNumber"));
                    m2.setPassportNumber(set.getString("passportNumber"));
                }
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
        return "CIT" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();  
    }

    private static String generatePassNo() {
		// TODO Auto-generated method stub
		return "PASS" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	private static String generateENo() {
		// TODO Auto-generated method stub
		return "ELEC" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	private static String generateEngineNo() {
		// TODO Auto-generated method stub
		return "ENG" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	private static String generateVRNo() {
		// TODO Auto-generated method stub
		return "VREG" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	private static String generateGasNumber() {
		// TODO Auto-generated method stub
		return "GAS" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
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

	public static double getUserBalance(String citizenId, String bank) 
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
	        try 
	        {
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

	public static boolean insertTaxPayment(TaxModel tx) {
	    boolean status = false;
	   
	    Connection con = Dao.getconnect();
	    
	    try {
	        PreparedStatement ps = con.prepareStatement("INSERT INTO tax_table (citizenId, taxPaid, taxDue) VALUES (?, ?, ?)");
	    
	        ps.setString(1, tx.getCitizenId());
	        ps.setDouble(2, tx.getTaxPaid());
	        ps.setDouble(3, tx.getTaxDue());
	   
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
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
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return status;
	}

	public static boolean updateUserAccountBalance(TaxModel tx) {
		Connection con = Dao.getconnect();
	    String updateQuery = "UPDATE user_accounts SET balance = balance - ? WHERE citizenId = ? AND bank = ? AND balance >= ?";
	    try ( 
	         PreparedStatement stmt = con.prepareStatement(updateQuery))
	    {
	        stmt.setDouble(1, tx.getTaxPaid());
	        stmt.setString(2, tx.getCitizenId());
	        stmt.setString(3, tx.getBank());
	        stmt.setDouble(4, tx.getTaxPaid()); 

	        int rowsUpdated = stmt.executeUpdate();
	        return rowsUpdated > 0; 
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	    return false;
	}

	public static boolean insertGasPayment(GasModel gs) {
	    boolean status = false;
	    Connection con = Dao.getconnect();
	   
	    try {
	        PreparedStatement ps = con.prepareStatement("INSERT INTO gas_service (citizenId, gasNumber, gasType, gasAmount) VALUES (?, ?, ?, ?)");
	        ps.setString(1, gs.getCitizenId());
	        ps.setString(2, gs.getGasNumber());
	        ps.setString(3, gs.getGasType());
	        ps.setDouble(4, gs.getGasAmount());

	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            status = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return status;
	}

	    
	public static boolean updateGasUserAccountBalance(GasModel gs) {
	    boolean status = false;
	    Connection con = Dao.getconnect();
	    PreparedStatement stmt = null;

	    try {
	        String query = "UPDATE user_accounts SET balance = balance - ? WHERE citizenId = ? AND bank = ? AND balance >= ?";
	        stmt = con.prepareStatement(query);
	        stmt.setDouble(1, gs.getGasAmount());  
	        stmt.setString(2, gs.getCitizenId()); 
	        stmt.setString(3, gs.getBank());      
	        stmt.setDouble(4, gs.getGasAmount()); 

	        int rowsUpdated = stmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            status = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (stmt != null) stmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return status;
	}

	


}
