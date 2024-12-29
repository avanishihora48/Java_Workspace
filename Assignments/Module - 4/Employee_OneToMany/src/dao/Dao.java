package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import connect.Util;
import model.Department;
import model.Employee;

public class Dao {

    public void insertEmployee(Employee emp, Department dept) {
        Session sess = new Util().getconnect();
        Transaction tr = sess.beginTransaction();
        sess.save(dept); 
        emp.setDepart(dept);
        sess.save(emp); 
        tr.commit(); 
        sess.close(); 
    }

    public List<Employee> getAllEmployees() {
        Session sess = new Util().getconnect();
        List<Employee> getall = sess.createQuery("from Employee").list(); 
        sess.close(); 
        return getall;
    }

    public void updateEmployeeDetails(int id, String newName, String newDepartment) {
        Session sess = new Util().getconnect();
        Transaction tr = sess.beginTransaction();
        Employee emp = sess.get(Employee.class, id);
        if (emp != null) {
            emp.setName(newName);
            Department dept = emp.getDepart();
            if (dept != null) {
                dept.setName(newDepartment);
            }
            sess.update(emp); 
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
        tr.commit(); 
        sess.close(); 
    }

    
    	public void deleteEmployee(int empId) {
    	    Session sess = new Util().getconnect();
    	    Transaction tr = sess.beginTransaction();
    	    Employee emp = sess.get(Employee.class, empId);
    	    if (emp != null) {
    	        sess.delete(emp); 
    	        System.out.println("Employee deleted successfully!");
    	    } else {
    	        System.out.println("Employee with ID " + empId + " not found.");
    	    }
    	    tr.commit();
    	    sess.close();
    	}

}
