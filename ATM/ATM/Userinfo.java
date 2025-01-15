package ATM;
import java.util.ArrayList;

public class Userinfo extends Account {//pojo class

   private double balance = 0;  // Account balance 
   private static ArrayList<Transaction> usertransaction = new ArrayList<Transaction>();


   public Userinfo(String id,String password,double balance) {
       super(id,password);
       this.balance=balance;

   }

   public static ArrayList<Transaction> getUsertransaction() {
       return usertransaction;
   }

  


  
   public double getBalance() {
      return balance;  // Return the account balance
   }

   
   public void setBalance(double balance) {
      this.balance = balance;  // Set the account balance
   }


}
