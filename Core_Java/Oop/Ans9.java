package OOP;

import java.util.Scanner;

abstract class Marks 
{
    abstract double getPercentage();
}

class A extends Marks 
{
    int marks1, marks2, marks3;
    static final int totalMarks = 300;
    
    public A(int mark1, int mark2, int mark3) {
        this.marks1 = mark1;
        this.marks2 = mark2;
        this.marks3 = mark3;
    }
    
    @Override
    double getPercentage() {
        int total = marks1 + marks2 + marks3;
        return (double) total / totalMarks * 100;
    }
}

class B extends Marks 
{
    int marks1, marks2, marks3, marks4;
    static final int totalMarks = 400;
    
    public B(int mark1, int mark2, int mark3, int mark4) {
        this.marks1 = mark1;
        this.marks2 = mark2;
        this.marks3 = mark3;
        this.marks4 = mark4;
    }
    
    @Override
    double getPercentage() 
    {
        int total = marks1 + marks2 + marks3 + marks4;
        return (double) total / totalMarks * 100;
    }
}

public class Ans9 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter marks for Student A in 3 subjects:");
        System.out.print("Subject 1: ");
        int aMark1 = sc.nextInt();
        System.out.print("Subject 2: ");
        int aMark2 = sc.nextInt();
        System.out.print("Subject 3: ");
        int aMark3 = sc.nextInt();

        A studentA = new A(aMark1, aMark2, aMark3);
        System.out.println("Percentage of Student A: " + studentA.getPercentage() + "%");

        System.out.println("Enter marks for Student B in 4 subjects:");
        System.out.print("Subject 1: ");
        int bMark1 = sc.nextInt();
        System.out.print("Subject 2: ");
        int bMark2 = sc.nextInt();
        System.out.print("Subject 3: ");
        int bMark3 = sc.nextInt();
        System.out.print("Subject 4: ");
        int bMark4 = sc.nextInt();

        B studentB = new B(bMark1, bMark2, bMark3, bMark4);
        System.out.println("Percentage of Student B: " + studentB.getPercentage() + "%");
    }
}
