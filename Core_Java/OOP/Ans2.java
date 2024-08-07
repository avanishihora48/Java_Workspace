package OOP;

    class Parent
	{
		void parent()
	     {
	    	 System.out.println("This is parent class..");
	     }
	}
     
	class Child extends Parent
	{
		void child()
	     {
	    	 System.out.println("This is child class..");
	     }
	}
     
public class Ans2 
	{
      public static void main(String[] args) 
     {
    	 Parent p = new Parent();
    	 p.parent();
    	 
		 Child c = new Child();
		 c.parent();
		 c.child();
		 
	 }
}
