import java.util.ArrayList;

public class Userinfo {
   private String user;
   private String pass;
   private double balance=0;
   private  ArrayList<String> Transaction=new ArrayList<String>();


public ArrayList<String>  getTransaction(){
return this.Transaction;
}

   public double getBalance() {
      return balance;
  }
  public void setBalance(double balance) {
      this.balance=balance;
  }

   public void setUser(String user){
this.user=user;
   }

   public void setPass(String pass){
    this.pass=pass;
       }
   @Override
   public String toString(){
    String user = this.user;
    String pass=this.pass;
    return user+" "+pass;
   }
public String getUser(){
    return this.user;

}
public String getpass(){
   return this.pass;

}
public void setpass(String p){
   this.pass=p;

}
    
}
