package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connect.Util;
import model.Employee;


public class Dao 
{

	public void insertdata(Employee emp) 
	{
		// TODO Auto-generated method stub
		Session sess = new Util().getconnect();
		Transaction tr = sess.beginTransaction();
		sess.save(emp);
		tr.commit();
		sess.close();
	}

	public void deletedata(Employee emp) 
	{
		// TODO Auto-generated method stub
		Session sess = new Util().getconnect();
		Transaction tr = sess.beginTransaction();
		sess.delete(emp);
		tr.commit();
		sess.close();
	}

	public void updatedata(Employee emp) {
		// TODO Auto-generated method stub
		Session sess = new Util().getconnect();
		Transaction tr = sess.beginTransaction();
		sess.update(emp);
		tr.commit();
		sess.close();
	}

	public List<Employee> viewdata() {
		// TODO Auto-generated method stub
		Session sess = new Util().getconnect();
		List<Employee> get1 = sess.createQuery("from Employee").list();
		sess.close();
		return get1;
	}

	public Employee getSingle(Employee emp) {
		// TODO Auto-generated method stub
		Session sess = new Util().getconnect();
		Employee person = (Employee) sess.get(Employee.class, emp.getId());
		sess.close();
		return person;
	}
	

	

}
