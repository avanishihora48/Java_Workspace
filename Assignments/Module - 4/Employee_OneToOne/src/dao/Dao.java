package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connect.Util;
import model.Employee;
import model.Profile;

public class Dao {

    public void insertEmployee(Employee emp, Profile pro) {
        // TODO Auto-generated method stub
        Session sess = new Util().getconnect();
        Transaction tr = sess.beginTransaction();
        sess.save(emp); 
        sess.save(pro); 
        tr.commit(); 
        sess.close(); 
    }

    public void updateEmployeeDetails(int i, String string, String newName, double newSalary) {
        // TODO Auto-generated method stub
        Session sess = new Util().getconnect();
        Transaction tr = sess.beginTransaction();

        Employee emp = sess.get(Employee.class, i);
        if (emp != null) {
            emp.setDepartment(string); 
            emp.setSalary(newSalary); 
            emp.setName(newName);
            sess.update(emp); 
        } else {
            System.out.println("Employee with ID " + i + " not found.");
        }

        tr.commit(); 
        sess.close(); 
    }

  
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        Session sess = new Util().getconnect();
        List<Employee> getall = sess.createQuery("from Employee").list(); 
        sess.close(); 
        return getall; 
    }

    public void deleteEmployee(int emp1) {
  
        Session sess = new Util().getconnect();
        Transaction tr = sess.beginTransaction();

        Employee emp = sess.get(Employee.class, emp1);

        if (emp != null) {
  
            Profile pro = sess.get(Profile.class, emp.getId()); 
            if (pro != null) {
                sess.delete(pro); 
            }

            sess.delete(emp);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee with ID " + emp1 + " not found.");
        }

        tr.commit();
        sess.close();
    }


}
