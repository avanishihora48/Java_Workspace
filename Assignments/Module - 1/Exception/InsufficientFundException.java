package Exception;

public class InsufficientFundException extends RuntimeException 
{
   private String message;
   
   public InsufficientFundException(String message) 
   {
	   this.message = message;
   }
   
   public InsufficientFundException(Throwable cause, String message)
   {
	   super(cause);
	   this.message = message;
   }
   public String getMessage()
   {
	  return message;
   }
}
