package Task;

public class Subject {
    public static void main(String[] args) {
    	int s1 = 90, s2 = 88, s3 = 89, s4 = 92, s5 = 80; 
    	int total = s1+s2+s3+s4+s5;
    	float per = ((total)/5);
		System.out.println("Marks of subject 1 is: "+s1);
		System.out.println("Marks of subject 2 is: "+s2);
		System.out.println("Marks of subject 3 is: "+s3);
		System.out.println("Marks of subject 4 is: "+s4);
		System.out.println("Marks of subject 5 is: "+s5);
		
		System.out.println("Total of all subject is: "+total);
		System.out.println("Percentace is: "+per+"%");
	}
}
