package ATM;


import java.util.Scanner;  // we need this to get input from the user.


import ATM.Notes.Notes;

public class ATMActions {  // this class contains actions related to the atm system.
    public static Scanner scanner = new Scanner(System.in);  // scanner to get user input.
    // this method starts the atm system and handles user/admin login and actions.
    static void start() throws CloneNotSupportedException {
        ATM.iniCurrencynotes();  // initialize the currency notes.
        ATM.getAccountlist().add(new Admininfo("admin", "123"));//default admin
        ATM:
        while (true) {  // this loop keeps running until the user chooses to exit.
            System.out.println("enter the choice admin or user or exit: ");  // ask for input from user.
           
            

           
            String inputUSerorAdmin = scanner.nextLine();  // get input.
           
            Useraction userAction = new Useraction();  // create an object for user actions.
            Adminaction adminAction = new Adminaction();  // create an object for admin actions.
           // set the admin list.

            if (inputUSerorAdmin.equals("user")) {  // if user chooses 'user'.
                Account currentUser = (Account) adminAction.login("user");  // login as user.
                if (currentUser == null) {  // if no user found.
                    System.out.println("no users found");
                } else if (currentUser.getId() == null) {  // if wrong password.
                    System.out.println("wrong password");
                } else {
                   ATMActions.userOperations((Userinfo)currentUser, userAction); // call user operations.
                }

            } else if (inputUSerorAdmin.equals("admin")) {  // if user chooses 'admin'.
                 // set the admin list again.
                Account currentAdmin = (Account) userAction.login("admin");  // login as admin.
                if (currentAdmin == null) {  // if no admin found.
                    System.out.println("no users found");
                } else if (currentAdmin.getId() == null) {  // if wrong password.
                    System.out.println("wrong password");
                } else {
                    adminOperations( currentAdmin, adminAction);  // call admin operations.
                }
            } else if (inputUSerorAdmin.equals("exit")) {  // if user wants to exit.
                break ATM;  // exit the loop.
            } else {  // if invalid input.
                System.out.println("invalid input:");  // display error message.
            }
        }
    }

    // this method updates the atm's cash based on available currency notes.
    public static void updateatmcash() {
        String no100 = "100";  // currency note of 100.
        String no500 = "500";  // currency note of 500.
        String no200 = "200";  // currency note of 200.
        String no2000 = "2000";  // currency note of 2000.
        long cur2000 = 0;  // store count of 2000 notes.
        long cur500 = 0;  // store count of 500 notes.
        long cur200 = 0;  // store count of 200 notes.
        long cur100 = 0;  // store count of 100 notes.
        for (Notes notes : ATM.getCurrencynotes()) {  // loop through all currency notes.
            if (no100.equals(notes.getNotes())) {
                cur100 = notes.getCount();  // get count of 100 notes.
            } else if (no500.equals(notes.getNotes())) {
                cur500 = notes.getCount();  // get count of 500 notes.
            } else if (no200.equals(notes.getNotes())) {
                cur200 = notes.getCount();  // get count of 200 notes.
            } else if (no2000.equals(notes.getNotes())) {
                cur2000 = notes.getCount();  // get count of 2000 notes.
            }
        }

        // calculate total atm cash based on the counts and denominations.
        double atmcash = cur2000 * 2000 + cur500 * 500 + cur200 * 200 + cur100 * 100;
        ATM.setatmcash(atmcash);  // set the total atm cash.
    }

    // this method checks if a user exists and if the password is correct.
    public static Account checkuser(String id) throws CloneNotSupportedException {


        for (Account account : ATM.getAccountlist()) {
            if (account instanceof Userinfo) {


        // loop through all users.
        if (id.equals(account.getId())) {  // if user ID matches.

            System.out.println("enter the password :");  // ask for password.
            String inputPassword = scanner.nextLine();  // get user input for password.
            for (int i = 0; i < 3; i++) {  // allow 3 attempts for password.
                if (inputPassword.equals(account.getPassword())) {  // if password matches.
                    return account;  // return user info.
                } else {
                    System.out.println("wrong pass try again :");  // if password is wrong.
                    inputPassword = scanner.nextLine();  // prompt for password again.
                    if (inputPassword.equals(account.getPassword())) {  // if password matches after retry.
                        return account;
                    } else if (i == 2) {  // if user fails 3 times.
                        return new Userinfo(null, null, 0);  // return a blank user object.
                    }
                }
            }
        }}}

        return null;  // if user not found or password incorrect.
    }

    // this method checks if an admin exists and if the password is correct.
    public static Account checkadmin(String id) throws CloneNotSupportedException {

        boolean foundUser=false;
        Account account=null;
        for (Account currentaccount : ATM.getAccountlist()) {
            if (currentaccount instanceof Admininfo) {
                if (id.equals(currentaccount.getId())) {
                    account=currentaccount;
                    foundUser=true;
                    break;
                }

            }}


        // if admin ID matches.
        if(foundUser){
        System.out.println("enter the password :");  // ask for password.
        String inputPassword = scanner.nextLine();  // get input for password.
        for (int i = 0; i < 3; i++) {  // allow 3 attempts for password.
            if (inputPassword.equals(account.getPassword())) {  // if password matches.
                return account;  // return admin info.
            } else {
                System.out.println("wrong pass try again :");  // if wrong password.
                inputPassword = scanner.nextLine();  // prompt for password again.
                if (inputPassword.equals(account.getPassword())) {  // if password matches after retry.
                    return account;
                } else if (i == 2) {  // if failed 3 times.
                    return new Admininfo(null, null);  // return a blank admin object.
                }}}}
                else{
                    return null;
                }
            
        


        return null;  // if admin not found or password incorrect.
    }

    




    // this method shows the current available notes in the atm.
    public static void currentnotes() {
        for (Notes notes : ATM.getCurrencynotes()) {  // loop through all notes.
            System.out.println(notes.getNotes() + " " + notes.getCount());  // print note and its count.
        }
    }


    public static void adminOperations(Account adminObject, Adminaction adminAction) {
        while (true) {
            // Display admin menu options
            System.out.println("\n1. Add User\n2. View All user\n3. Delete user\n4. view All Transaction\n5. Deposit cash in ATM\n6.view atm balance\n7. Exit:");
           
            int userChoice = Integer.parseInt(scanner.nextLine());
            switch (userChoice) {
                case 1:
                adminAction.adduser();
                    break;  // Call add user
                case 2:
                adminAction.viewalluser();
                    break;  // View all users
                case 3:
                adminAction.deleteuser();
                    break;  // Delete user
                case 4:
                adminAction.viewtransaction( adminObject);
                    break;  // View transactions
                case 5:
                adminAction.depositcash(adminObject);
                    break; 
                case 6:
                adminAction.atmBalance(); // Deposit cash in ATM
                case 7:
                    return;  // Exit
                default:
                    System.out.println("INVALID input:");  // Invalid input
            }
        }
    }

    public static void userOperations(Userinfo currentUser, Useraction useraction) throws CloneNotSupportedException {
        while (true) {
            // Display options for the user to choose from
            System.out.println("\n1. Check Balance\n2. Withdraw Cash\n3. Deposit Cash\n4. Change Pin\n5. Transaction\n6. Exit:");
            String uc = scanner.nextLine();
            int ucho = Integer.parseInt(uc);  // Parse user input
           
            switch (ucho) {
                case 1:
                useraction.checkbalance(currentUser);  // Check balance
                    break;
                case 2:
                useraction.withdrawcash(currentUser);  // Withdraw cash
                    break;
                case 3:
                useraction.depositcash(currentUser);  // Deposit cash
                    break;
                case 4:
                useraction.changepin(currentUser);  // Change PIN
                    break;
                case 5:
                useraction.viewtransaction(currentUser); // View transactions
                    break;
                case 6:
                    return;  // Exit
                default:
                    System.out.println("INVALID input:");  // Invalid input handling
            }
        }
    }

}
