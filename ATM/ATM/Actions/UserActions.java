package ATM.Actions;




import ATM.Account;
import ATM.Userinfo;



public interface UserActions {//interface for the admin actions

    public void checkbalance(Userinfo currentUserObject);//method declarations for the admin actions


    public void withdrawcash(Userinfo currentUserObject)throws CloneNotSupportedException;

    public void changepin(Userinfo currentUserObject);

    public void depositcash(Account AdminObject);

    public void viewtransaction(Account AdminObject);

   
} 
    

