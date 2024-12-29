package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="profile1")
public class Profile 
{
   @OneToOne

   private Employee employee;
   
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

   @Id
   @GenericGenerator(name = "increment", strategy = "increment")
   @GeneratedValue(generator="increment")
   @Column(name = "profile_id")
   private int id;
   
   @Column(name = "address")
   private String address;
	
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getAddress() {
			return address;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}

		
   
}
