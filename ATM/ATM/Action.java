package ATM;

import java.util.Scanner;  // we need this to get input from the user.

public class Action {  // this is the action class where we define what to do in the atm system.

    // this method handles login. it takes 'choice' admin or user
    public static Object login(String choice, Scanner scanner) throws CloneNotSupportedException {
        System.out.println("enter the user name: "); 
        String inuputUsername = scanner.nextLine();  // reading the username from the user.

        if (choice.equals("admin")) {  // check if it's an admin login.

            // if it's admin, check admin info using the username.
            Account AdminObject = ATMActions.checkadmin(inuputUsername, scanner);

            return AdminObject;  // return the admin details.(admin object)

        } else {  // if it's not admin the user
            // check user info using the username.
            Account userObject = ATMActions.checkuser(inuputUsername, scanner);

            return userObject;  // return the user details.(user object)

        }
    }

    // this method is meant to add a new user (but not yet implemented,implemented in inheited class).
    public void adduser(Scanner scanner) {

    }

    // this method is meant to delete a user (but not yet implemented,implemented in inheited class).
    public void deleteuser(Scanner scanner) {

    }

    // this method should show all users (but not yet implemented,implemented in inheited class).
    public void viewalluser() {

    }

    // this method should show all transactions (but not yet implemented,implemented in inheited class).
    public void viewalltransaction(Scanner scanner,Admininfo b) {

    }

    // this method should let admin deposit cash (but not yet implemented,implemented in inheited class).
    public void depositcash(Admininfo AdminObject, Scanner scanner) {

    }

    // this method should let a user deposit cash (but not yet implemented,implemented in inheited class).
    public void userdepositcash(Userinfo currentUserObject, Scanner scanner) {

    }

    // this method should let a user check their balance (but not yet implemented,implemented in inheited class).
    public void checkbalance(Userinfo currentUserObject) {

    }

    // this method should let a user withdraw cash (but not yet implemented,implemented in inheited class).
    public void withdrawcash(Userinfo currentUserObject, Scanner scanner) throws CloneNotSupportedException {

    }

    // this method should let a user change their pin (but not yet implemented,implemented in inheited class).
    public void changepin(Userinfo currentUserObject, Scanner scanner) {

    }

    // this method should show user transactions (but not yet implemented ,implemented in inheited class).
    public void userTransaction(Userinfo currentUserObject) {

    }

}
