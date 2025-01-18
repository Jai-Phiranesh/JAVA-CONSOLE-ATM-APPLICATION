package ATM;


public class Userinfo extends Account {//pojo class

   private double balance = 0;  // Account balance 
  


   public Userinfo(String id,String password,double balance) {
       super(id,password);
       this.balance=balance;

   }

   

  


  
   public double getBalance() {
      return balance;  // Return the account balance
   }

   
   public void setBalance(double balance) {
      this.balance = balance;  // Set the account balance
   }


}
