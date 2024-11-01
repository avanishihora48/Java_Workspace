package Task;

public class leap_year {
	public static void main(String[] args) {
		int year = 2021;
		
		if (year % 400 == 0) {
	        System.out.println("This year is leap year");
	    } else if (year % 100 == 0) {
	    	 System.out.println("This year is not leap year");
	    } else if (year % 4 == 0) {
	    	 System.out.println("This year is leap year");
	    } else {
	    	 System.out.println("This year is not leap year");
	    }
	 }
}
