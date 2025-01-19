package ATM;

import java.util.Scanner;  // we need this to get input from the user.

import ATM.Actions.Actions;


public class Action implements Actions {  // this is the action class where we define what to do in the atm system.
    public static Scanner scanner = new Scanner(System.in);
    // this method handles login. it takes 'choice' admin or user
    @Override
    public  Object login(String choice) throws CloneNotSupportedException {
        System.out.println("enter the user name: "); 
        String inuputUsername = scanner.nextLine();  // reading the username from the user.

        if (choice.equals("admin")) {  // check if it's an admin login.

            // if it's admin, check admin info using the username.
            Account AdminObject = ATMActions.checkadmin(inuputUsername);

            return AdminObject;  // return the admin details.(admin object)

        } else {  // if it's not admin the user
            // check user info using the username.
            Account userObject = ATMActions.checkuser(inuputUsername);

            return userObject;  // return the user details.(user object)

        }
    }

}
