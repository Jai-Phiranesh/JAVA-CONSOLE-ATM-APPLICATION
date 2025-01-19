package ATM.Actions;

import ATM.Account;

public interface AdminActions {//interface for the admin actions
    public void adduser();//method declarations for the admin actions

    public void deleteuser();

    public void viewalluser();

    public void depositcash(Account AdminObject);

    public void viewtransaction(Account AdminObject);

    
} 
