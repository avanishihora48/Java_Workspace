package Assessment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Assessment_1 implements ActionListener 
{
    JFrame frame;
    JButton btnInsert, btnSearch, btnUpdate, btnDelete;
    JLabel lid, lfn, lln, lem, lmob; 
    JTextField tid, tfn, tln, tem, tmob;

    public Assessment_1() 
    {
        frame = new JFrame("FORM");
       

        lid = new JLabel("ID (for Search/Update/Delete):");
        lid.setBounds(50, 20, 200, 20);
        tid = new JTextField();
        tid.setBounds(250, 20, 150, 20);

        lfn = new JLabel("First Name:"); 
        lfn.setBounds(50, 60, 200, 20);
        tfn = new JTextField();
        tfn.setBounds(250, 60, 150, 20);

        lln = new JLabel("Last Name:"); 
        lln.setBounds(50, 100, 200, 20);
        tln = new JTextField();
        tln.setBounds(250, 100, 150, 20);

        lem = new JLabel("Email:");
        lem.setBounds(50, 140, 200, 20);
        tem = new JTextField();
        tem.setBounds(250, 140, 150, 20);

        lmob = new JLabel("Mobile:");
        lmob.setBounds(50, 180, 200, 20);
        tmob = new JTextField();
        tmob.setBounds(250, 180, 150, 20);

        btnInsert = new JButton("Insert");
        btnInsert.setBounds(50, 220, 150, 30);
        btnInsert.addActionListener(this);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(250, 220, 150, 30);
        btnSearch.addActionListener(this);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(50, 270, 150, 30);
        btnUpdate.addActionListener(this);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(250, 270, 150, 30);
        btnDelete.addActionListener(this);

        frame.add(lid);
        frame.add(tid);
        frame.add(lfn);
        frame.add(tfn);
        frame.add(lln);
        frame.add(tln);
        frame.add(lem);
        frame.add(tem);
        frame.add(lmob);
        frame.add(tmob);
        frame.add(btnInsert);
        frame.add(btnSearch);
        frame.add(btnUpdate);
        frame.add(btnDelete);

        frame.setSize(500, 400);
        frame.setLayout(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Assessment_1();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == btnInsert) 
        {
            insertData();
        } 
        else if (e.getSource() == btnSearch) 
        {
            searchData();
        } 
        else if (e.getSource() == btnUpdate) 
        {
            updateData();
        } 
        else if (e.getSource() == btnDelete) 
        {
            deleteData();
        }
    }

    public void insertData() 
    {
        String firstName = tfn.getText();
        String lastName = tln.getText();
        String email = tem.getText();
        String mobile = tmob.getText();

        String dbname = "assessment";
        String host = "jdbc:mysql://localhost:3306/";
        String url = host + dbname;

        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            String sql = "INSERT INTO student (firstname, lastname, email, mobile) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, mobile);
            int status = pstmt.executeUpdate();

            if (status > 0) 
            {
                System.out.println("Data inserted successfully!");
            } 
            else 
            {
                System.out.println("Insert error");
            }
            con.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }

    public void searchData() 
    {
        String input = tid.getText();
        try 
        {
            if (input != null && !input.trim().isEmpty()) 
            {
                int number = Integer.parseInt(input);
           
                String dbname = "assessment";
                String host = "jdbc:mysql://localhost:3306/";
                String url = host + dbname;

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root", "");
                String sql = "SELECT firstname, lastname, email, mobile FROM student WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, number);
                ResultSet rs = pstmt.executeQuery();
                                                
                if (rs.next()) {
                    tfn.setText(rs.getString("firstname"));
                    tln.setText(rs.getString("lastname"));
                    tem.setText(rs.getString("email"));
                    tmob.setText(rs.getString("mobile"));
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "No data found for the given ID.");
                }
                con.close();
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    public void updateData() 
    {
        String input = tid.getText(); 
        try 
        {
            if (input != null && !input.trim().isEmpty()) 
            {
                int id = Integer.parseInt(input);
                String firstName = tfn.getText();
                String lastName = tln.getText();
                String email = tem.getText();
                String mobile = tmob.getText();

                String dbname = "assessment";
                String host = "jdbc:mysql://localhost:3306/";
                String url = host + dbname;

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root", "");
                String sql = "UPDATE student SET firstname = ?, lastname = ?, email = ?, mobile = ? WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, email);
                pstmt.setString(4, mobile);
                pstmt.setInt(5, id);
                int status = pstmt.executeUpdate();

                if (status > 0) 
                {
                    System.out.println("Data updated successfully!");
                } 
                else 
                {
                    System.out.println("Update error: No records updated.");
                }
                con.close();
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for ID.");
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    public void deleteData() 
    {
        String input = tid.getText(); 
        try 
        {
            if (input != null && !input.trim().isEmpty()) 
            {
                int id = Integer.parseInt(input);

                String dbname = "assessment";
                String host = "jdbc:mysql://localhost:3306/";
                String url = host + dbname;

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root", "");
                String sql = "DELETE FROM student WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);
                int status = pstmt.executeUpdate();

                if (status > 0) 
                {
                    System.out.println("Data deleted successfully!");
                } 
                else 
                {
                    System.out.println("Delete error");
                }
                con.close();
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
        } 
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for ID.");
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }
}
