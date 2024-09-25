import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Java_database implements ActionListener 
{
    JFrame fr;
    JTextField jid, jname, jadd, jcon;
    JLabel id, name, add, cont, register, gender;
    JRadioButton male, female;
    JButton exit, reg, del, update, reset, refresh;

    JTable jt;
    JScrollPane jscroll;
    DefaultTableModel model;

    Font font = new Font("Times New Roman", Font.BOLD, 60);

    public Java_database() 
    {
        fr = new JFrame("Registration Form");

        jid = new JTextField(15);
        jid.setBounds(130, 49, 167, 34);
        jname = new JTextField(15);
        jname.setBounds(130, 87, 167, 34);
        jadd = new JTextField(15);
        jadd.setBounds(130, 175, 167, 34);
        jcon = new JTextField(15);
        jcon.setBounds(130, 215, 167, 34);

        id = new JLabel("ID");
        id.setBounds(35, 58, 60, 16);
        
        name = new JLabel("Name");
        name.setBounds(35, 96, 60, 16);
        
        add = new JLabel("Address");
        add.setBounds(35, 184, 60, 16);
        
        cont = new JLabel("Contact");
        cont.setBounds(35, 224, 60, 16);
        
        register = new JLabel("Registration Form");
        register.setBounds(61, 13, 157, 23);
        
        gender = new JLabel("Gender");
        gender.setBounds(35, 139, 64, 25);

        male = new JRadioButton("Male");
        male.setBounds(125, 139, 70, 25);
        female = new JRadioButton("Female");
        female.setBounds(200, 139, 80, 25);

        exit = new JButton("Exit");
        exit.setBounds(35, 277, 107, 34);
        reg = new JButton("Register");
        reg.setBounds(150, 277, 120, 34);
        del = new JButton("Delete");
        del.setBounds(35, 317, 107, 34);
        
        update = new JButton("Update");
        update.setBounds(150, 317, 120, 34);
        
        reset = new JButton("Reset");
        reset.setBounds(87, 356, 120, 34);
        
        refresh = new JButton("Refresh Table");
        refresh.setBounds(550, 403, 300, 34);

        String column[] = {"S.no", "ID", "Name", "Gender", "Address", "Contact"};

        model = new DefaultTableModel(column, 0);
        jt = new JTable(model);
        jt.setBounds(200, 13, 600, 200);
        
        jscroll = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jscroll.setBounds(350, 13, 650, 377);

        fr.setSize(1090, 600);
        fr.setLayout(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        fr.add(register);
        fr.add(id);
        fr.add(jid);
        fr.add(name);
        fr.add(jname);
        fr.add(gender);
        fr.add(male);
        fr.add(female);
        fr.add(add);
        fr.add(jadd);
        fr.add(jcon);
        fr.add(cont);
        fr.add(exit);
        fr.add(update);
        fr.add(del);
        fr.add(refresh);
        fr.add(reg);
        fr.add(refresh);
        fr.add(jscroll);
        fr.add(reset);
        
        reg.addActionListener(this);
        exit.addActionListener(this);
        del.addActionListener(this);
        reset.addActionListener(this);
        update.addActionListener(this);
        refresh.addActionListener(this);
    }

    String host = "jdbc:mysql://localhost:3306/";
    String dbname = "employee";
    String url = host + dbname;

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reg) 
        {
            insertData();
        }
        if (e.getSource() == exit) 
        {
            fr.dispose();
        }
        if (e.getSource() == del) 
        {
            deleteData();
        }
        if (e.getSource() == reset) 
        {
            jid.setText(null);
            jname.setText(null);
            female.setSelected(false);
            male.setSelected(false);
            jadd.setText(null);
            jcon.setText(null);
        }
        if (e.getSource() == update) {
            updateData();
        }
        if (e.getSource() == refresh) {
            viewDataInTable();
        }
    }

    public void insertData() 
    {
        try 
        {
            int id = Integer.parseInt(jid.getText());
            String nam = jname.getText();
            String gend = male.isSelected() ? male.getText() : female.getText();
            String add = jadd.getText();
            long cont = Long.parseLong(jcon.getText());

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();

            String sqlinsert = "INSERT INTO employee_data (id, name, gender, address, contact) VALUES ('" + id + "','" + nam + "', '" + gend + "','" + add + "','" + cont + "')";
            stmt.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(reg, "Registered Successfully");
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }


    public void deleteData() 
    {
        int delete1;
        int id = Integer.parseInt(jid.getText());
        String sqldelete = "DELETE FROM employee_data WHERE ID='" + id + "'";
                
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            delete1 = stmt.executeUpdate(sqldelete);
            JOptionPane.showMessageDialog(del, "Deleted Successfully");
            stmt.close();
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    

    public void updateData() 
    {
        int update1;
        int id = Integer.parseInt(jid.getText());
        String nam = jname.getText();
                    
        String gend;
        if (male.isSelected()) 
        {
            gend = male.getText();
        }
        else 
        {
            gend = female.getText();
        }
        
        String add = jadd.getText();
        long cont = Long.parseLong(jcon.getText());
        String sqlupdate = "UPDATE employee_data SET ID=" + id + ", Name='" + nam + "', Gender='" + gend + "', Address='" + add + "', Contact=" + cont + " WHERE ID=" + id;

        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            update1 = stmt.executeUpdate(sqlupdate);
            JOptionPane.showMessageDialog(update, "Updated Successfully");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewDataInTable() 
    {
        String sqlviewdata = "SELECT * FROM employee_data"; 
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlviewdata);

            model.setRowCount(0); 

            while (rs.next()) 
            {
                model.addRow(new Object[]
                {
                    rs.getInt("sno"),    
                    rs.getInt("id"),     
                    rs.getString("name"), 
                    rs.getString("gender"), 
                    rs.getString("address"), 
                    rs.getLong("contact")  
                });
            }
            stmt.close();
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }


    public static void main(String[] args) 
    {
        new Java_database();
    }
}
