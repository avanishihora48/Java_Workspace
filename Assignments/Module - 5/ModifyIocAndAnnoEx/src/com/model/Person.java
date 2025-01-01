package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person 
{
    @Autowired
    @Qualifier("address")
    private Address address;
    
    private String name = "John Doe";
    private int age = 28;
    
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
	@Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address + "}";
    }
}
