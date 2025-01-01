package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.model.ContactModel;
import com.model.CreditRatingModel;
import com.model.ElectricityModel;
import com.model.GasModel;
import com.model.InsuranceModel;
import com.model.Model;
import com.model.RtoModel;
import com.model.TaxModel;
import com.model.TelephoneModel;
import com.model.TransactionModel;
import com.model.VoteModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
	        e.printStackTrace();
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
	        e.printStackTrace();
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
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    } 
	    return status;
	}

	public static boolean insertRtoPayment(RtoModel rto) {
		// TODO Auto-generated method stub
		 boolean status = false;
		 Connection con = Dao.getconnect();
		 
		 try 
		 {
			PreparedStatement ps = con.prepareStatement("INSERT into rto_service(citizenId, vehicleRegistrationNo,	engineNumber, transactionDate, payAmount) VALUES (?, ? ,?, ?, ?)");
			 ps.setString(1, rto.getCitizenId());
             ps.setString(2, rto.getVehicleRegistrationNo());
             ps.setString(3, rto.getEngineNumber());
             ps.setTimestamp(4, rto.getTransactionDate());
             ps.setDouble(5, rto.getPayAmount());
            
             int rowsAffected = ps.executeUpdate();
 	        if (rowsAffected > 0) 
 	        {
 	            status = true;
 	        }
 	    } 
		 catch (SQLException e) 
		 {
 	        e.printStackTrace();
 	    } 
 	    return status;
      } 
		
	public static boolean updateRtoUserAccountBalance(RtoModel rto) {
		 boolean status = false;
		    Connection con = Dao.getconnect();
		    PreparedStatement ps = null;

		    try {
		        String query = "UPDATE user_accounts SET balance = balance - ? WHERE citizenId = ? AND bank = ? AND balance >= ?";
		        ps = con.prepareStatement(query);
		        ps.setDouble(1, rto.getPayAmount()); 
		        ps.setString(2, rto.getCitizenId()); 
		        ps.setString(3, rto.getBank()); 
		        ps.setDouble(4, rto.getPayAmount()); 
		        int rowsUpdated = ps.executeUpdate();
		        if (rowsUpdated > 0) {
		            status = true;
		        }
		    } 
		    catch (SQLException e) 
		    {
		        e.printStackTrace();
		    } 
		    return status;
	}

	public static boolean saveVote(VoteModel vm) {
		// TODO Auto-generated method stub
		boolean status = false;
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("INSERT into votes  (citizenId, area, candidate, votingDate) VALUES (?, ?, ?, ?)");
			ps.setString(1, vm.getCitizenId());
            ps.setString(2, vm.getArea());
            ps.setString(3, vm.getCandidate());
            ps.setTimestamp(4, vm.getVotingDate());
		
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) 
            {
                status = true;
            }
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

	public static boolean hasVoted(String citizenId) {
		// TODO Auto-generated method stub
		boolean status = false;
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM votes WHERE citizenId = ?");
			ps.setString(1, citizenId);
			 ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return rs.getInt(1) > 0;  
	            }
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static boolean saveCallDetails(TelephoneModel tm) {
	    boolean status = false;
	    try (Connection con = Dao.getconnect();
	         PreparedStatement ps = con.prepareStatement("INSERT INTO tel_service (citizenId, callType, callStartTime, callDuration, callRate, callCharges) VALUES (?, ?, ?, ?, ?, ?)")) {

	        ps.setString(1, tm.getCitizenId());
	        ps.setString(2, tm.getCallType());
	        ps.setTimestamp(3, tm.getCallStartTime());
	        ps.setLong(4, tm.getCallDuration());
	        ps.setInt(5, tm.getCallRate());
	        ps.setDouble(6, tm.getCallCharges());

	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            status = true;
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	    return status;
	}

	public static boolean updateUserCallAccount(String citizenId, double callCharges) {
	    boolean status = false; 
	    try (Connection con = Dao.getconnect();
	         PreparedStatement ps = con.prepareStatement(
	             "UPDATE user_accounts SET balance = balance - ? WHERE citizenId = ? AND balance >= ?")) {

	        ps.setDouble(1, callCharges);  
	        ps.setString(2, citizenId);   
	        ps.setDouble(3, callCharges); 

	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            status = true; 
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	    return status;
	}

	public static boolean insertUserCharges(ElectricityModel em) {
		// TODO Auto-generated method stub
		boolean status = false;
		Connection con = Dao.getconnect();
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("INSERT into electricity_service(citizenId, previousUnits, currentUnits, ratePerUnit, totalCharges) VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, em.getCitizenId());
			ps.setInt(2, em.getPreviousUnits());
			ps.setInt(3, em.getCurrentUnits());
			ps.setDouble(4, em.getRatePerUnit());
			ps.setDouble(5, em.getTotalCharges());
			
			int rowsAffected = ps.executeUpdate();
			
			 if (rowsAffected > 0) 
			 {
	             return true; 
	         } 
			 else 
			 {
	             return false; 
	         }
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
		
	public static boolean updateUserCharges(String citizenId,  double totalCharges) {
	    boolean status = false; 
	    Connection con = Dao.getconnect();
	    
	    try {
	        
	        PreparedStatement ps = con.prepareStatement("UPDATE user_accounts SET balance = balance - ? WHERE citizenId = ? AND balance >= ?");
	    
	        ps.setDouble(1, totalCharges);  
	        ps.setString(2, citizenId);     
	        ps.setDouble(3, totalCharges);  
	
	        int rowsUpdated = ps.executeUpdate();
	 
	        if (rowsUpdated > 0) {
	            status = true; 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return status;
	}

	  public static void savePassportInfo(String citizenId, String fullName, String passportNumber, String dateIssued, Timestamp validUntil) {
	        Connection con = getconnect();
	        
	        try {
	            
	            String query = "INSERT INTO passport_info (citizenId, fullName, passportNumber, dateIssued, validUntil) VALUES (?, ?, ?, ?, ?)";
	     
	            PreparedStatement ps = con.prepareStatement(query);
	   
	            ps.setString(1, citizenId);       
	            ps.setString(2, fullName);         
	            ps.setString(3, passportNumber);  
	            ps.setString(4, dateIssued);      
	            ps.setTimestamp(5, validUntil);    
	
	            int status = ps.executeUpdate();
	            
	            if (status > 0) {
	                System.out.println("Passport information saved successfully.");
	            } else {
	                System.out.println("Failed to save passport information.");
	            }
	            
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	    }
	
	  public static int contactinsertdata(ContactModel cm)
		{
			int status = 0;
			
			Connection con = Dao.getconnect();
			
			
			try 
			{
				PreparedStatement ps = con.prepareStatement("insert into contact(email,subject,message) values (?,?,?)");
				ps.setString(1,cm.getEmail());
				ps.setString(2,cm.getSubject());
				ps.setString(3,cm.getMessage());
				
				status = ps.executeUpdate();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return status;
		}

	public static boolean saveCreditRating(CreditRatingModel cr) {
		// TODO Auto-generated method stub
		boolean status = false;
		Connection con = Dao.getconnect();
		try 
		{
			PreparedStatement ps = con.prepareStatement("INSERT into credit_ratings(name, behavior,	rating) VALUES (?,?,?)");
			ps.setString(1,cr.getName());
			ps.setString(2,cr.getBehavior());
			ps.setString(3, cr.getRating());
			
			int rowsUpdated = ps.executeUpdate();
			 
	        if (rowsUpdated > 0) {
	            status = true; 
	        }
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
