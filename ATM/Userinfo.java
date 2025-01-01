
public class Userinfo {//pojo class
   private String user;  // Username for the user
   private String pass;  // Password for the user
   private double balance = 0;  // Account balance 

   // Default constructor to create object
   public Userinfo() {

   }

  
   public Userinfo(String user, String pass) {
      this.user = user;  // Set the username
      this.pass = pass;  // Set the password
   }

  
   public double getBalance() {
      return balance;  // Return the account balance
   }

   
   public void setBalance(double balance) {
      this.balance = balance;  // Set the account balance
   }

   // Override the toString method to return the username as a string(Object class tostring overrided)
   @Override
   public String toString() {
      return this.user;  // Return the user's name
   }

  
   public String getUser() {
      return this.user;  // Return the username
   }

   
   public String getPass() {
      return this.pass;  // Return the password
   }

   
   public void setPass(String p) {
      this.pass = p;  // Set the new password
   }
}
