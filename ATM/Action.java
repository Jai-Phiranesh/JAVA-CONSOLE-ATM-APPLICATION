import java.util.Scanner;  // we need this to get input from the user.

public class Action {  // this is the action class where we define what to do in the atm system.

    // this method handles login. it takes 'choice' admin or user
    public static Object login(String choice, Scanner ob) throws CloneNotSupportedException {
        System.out.println("enter the user name: "); 
        String inu = ob.nextLine();  // reading the username from the user.

        if (choice.equals("admin")) {  // check if it's an admin login.

            // if it's admin, check admin info using the username.
            Admininfo Ao = ATMActions.checkadmin(inu, ob);  

            return Ao;  // return the admin details.(admin object)

        } else {  // if it's not admin the user
            // check user info using the username.
            Userinfo uo = ATMActions.checkuser(inu, ob);  

            return uo;  // return the user details.(user object)

        }
    }

    // this method is meant to add a new user (but not yet implemented,implemented in inheited class).
    public void adduser(Scanner ob) {

    }

    // this method is meant to delete a user (but not yet implemented,implemented in inheited class).
    public void deleteuser(Scanner ob) {

    }

    // this method should show all users (but not yet implemented,implemented in inheited class).
    public void viewalluser() {

    }

    // this method should show all transactions (but not yet implemented,implemented in inheited class).
    public void viewalltransaction(Scanner ob) {

    }

    // this method should let admin deposit cash (but not yet implemented,implemented in inheited class).
    public void depositcash(Admininfo aob, Scanner ob) {

    }

    // this method should let a user deposit cash (but not yet implemented,implemented in inheited class).
    public void userdepositcash(Userinfo cub, Scanner scob) {

    }

    // this method should let a user check their balance (but not yet implemented,implemented in inheited class).
    public void checkbalance(Userinfo cub) {

    }

    // this method should let a user withdraw cash (but not yet implemented,implemented in inheited class).
    public void withdrawcash(Userinfo cub, Scanner scob) throws CloneNotSupportedException {

    }

    // this method should let a user change their pin (but not yet implemented,implemented in inheited class).
    public void changepin(Userinfo cub, Scanner scob) {

    }

    // this method should show user transactions (but not yet implemented ,implemented in inheited class).
    public void userTransaction(Userinfo cub) {

    }

}
