import java.util.ArrayList;

public class Userinfo {
   private String user;
   private String pass;
   private double balance = 0;
   private ArrayList<String> Transaction = new ArrayList<String>();
   boolean threat=false;

   public void setThreat(boolean threat) {
       this.threat = threat;
   }
public boolean getThreat(){
   return this.threat;
}

   public Userinfo() {

   }

   public Userinfo(String user, String pass) {
      this.user = user;
      this.pass = pass;
   }

   public ArrayList<String> getTransaction() {
      return Transaction;
   }

   public double getBalance() {
      return balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   @Override

   public String toString() {
      return this.user;
   }

   public String getUser() {
      return this.user;

   }

   public String getPass() {
      return this.pass;

   }

   public void setPass(String p) {
      this.pass = p;

   }

   

}
