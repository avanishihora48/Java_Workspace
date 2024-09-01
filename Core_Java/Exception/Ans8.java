package Exception;

import java.util.Scanner;

public class Ans8 
{
    private int rollNo;
    private String name;
    private int age;
    private String course;

    
    public Ans8(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException 
    {
        this.rollNo = rollNo;
        setName(name); 
        setAge(age);   
        this.course = course;
    }

    
    private void setAge(int age) throws AgeNotWithinRangeException 
    {
        if (age < 15 || age > 21) 
        {
            throw new AgeNotWithinRangeException("Age is not within the allowed range (15-21).");
        }
        this.age = age;
    }

    private void setName(String name) throws NameNotValidException 
    {
        if (name == null || !name.matches("[a-zA-Z]+")) 
        { 
            throw new NameNotValidException("Name is not valid. It should contain only alphabets.");
        }
        this.name = name;
    }

    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        try {
            
            System.out.println("Enter roll number: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Enter course: ");
            String course = sc.nextLine();

            
            Ans8 student = new Ans8(rollNo, name, age, course);
            System.out.println("Student created successfully!");

        } 
        catch (AgeNotWithinRangeException | NameNotValidException e) 
        {
            System.out.println(e.getMessage());
        } 
    }
}