package ATM;

import java.util.Scanner;  // we need this to get input from the user.


import ATM.Notes.Notes;

public class ATMActions {  // this class contains actions related to the atm system.

    // this method starts the atm system and handles user/admin login and actions.
    static void start() throws CloneNotSupportedException {
        ATM.iniCurrencynotes();  // initialize the currency notes.
        ATM.getAccountlist().add(new Admininfo("1", "1"));//default admin
        ATM:
        while (true) {  // this loop keeps running until the user chooses to exit.
            System.out.println("enter the choice admin or user or exit: ");  // ask for input from user.

            Scanner sob = new Scanner(System.in);  // scanner to get user input.
            String in = sob.nextLine();  // get input.
           
            Useraction uaob = new Useraction();  // create an object for user actions.
            Adminaction aaob = new Adminaction();  // create an object for admin actions.
           // set the admin list.

            if (in.equals("user")) {  // if user chooses 'user'.
                Account u = (Account) Action.login("user", sob);  // login as user.
                if (u == null) {  // if no user found.
                    System.out.println("no users found");
                } else if (u.getId() == null) {  // if wrong password.
                    System.out.println("wrong password");
                } else {
                    Useraction.operations((Userinfo) u, uaob, sob);  // call user operations.
                }

            } else if (in.equals("admin")) {  // if user chooses 'admin'.
                 // set the admin list again.
                Account a = (Account) Action.login("admin", sob);  // login as admin.
                if (a == null) {  // if no admin found.
                    System.out.println("no users found");
                } else if (a.getId() == null) {  // if wrong password.
                    System.out.println("wrong password");
                } else {
                    Adminaction.operations((Admininfo) a, aaob, sob);  // call admin operations.
                }
            } else if (in.equals("exit")) {  // if user wants to exit.
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
        for (Notes n : ATM.getCurrencynotes()) {  // loop through all currency notes.
            if (no100.equals(n.getNotes())) {
                cur100 = n.getCount();  // get count of 100 notes.
            } else if (no500.equals(n.getNotes())) {
                cur500 = n.getCount();  // get count of 500 notes.
            } else if (no200.equals(n.getNotes())) {
                cur200 = n.getCount();  // get count of 200 notes.
            } else if (no2000.equals(n.getNotes())) {
                cur2000 = n.getCount();  // get count of 2000 notes.
            }
        }

        // calculate total atm cash based on the counts and denominations.
        double atmcash = cur2000 * 2000 + cur500 * 500 + cur200 * 200 + cur100 * 100;
        ATM.setatmcash(atmcash);  // set the total atm cash.
    }

    // this method checks if a user exists and if the password is correct.
    public static Account checkuser(String id, Scanner sob) throws CloneNotSupportedException {


        for (Account ob : ATM.getAccountlist()) {
            if (ob instanceof Userinfo) {





        // loop through all users.
        if (id.equals(ob.getId())) {  // if user ID matches.

            System.out.println("enter the password :");  // ask for password.
            String inp = sob.nextLine();  // get user input for password.
            for (int i = 0; i < 3; i++) {  // allow 3 attempts for password.
                if (inp.equals(ob.getPassword())) {  // if password matches.
                    return ob;  // return user info.
                } else {
                    System.out.println("wrong pass try again :");  // if password is wrong.
                    inp = sob.nextLine();  // prompt for password again.
                    if (inp.equals(ob.getPassword())) {  // if password matches after retry.
                        return ob;
                    } else if (i == 2) {  // if user fails 3 times.
                        return new Userinfo(null, null, 0);  // return a blank user object.
                    }
                }
            }
        }}}

        return null;  // if user not found or password incorrect.
    }

    // this method checks if an admin exists and if the password is correct.
    public static Account checkadmin(String id, Scanner sob) throws CloneNotSupportedException {


        for (Account ob : ATM.getAccountlist()) {
            if (ob instanceof Admininfo) {


        // if admin ID matches.

        System.out.println("enter the password :");  // ask for password.
        String inp = sob.nextLine();  // get input for password.
        for (int i = 0; i < 3; i++) {  // allow 3 attempts for password.
            if (inp.equals(ob.getPassword())) {  // if password matches.
                return ob;  // return admin info.
            } else {
                System.out.println("wrong pass try again :");  // if wrong password.
                inp = sob.nextLine();  // prompt for password again.
                if (inp.equals(ob.getPassword())) {  // if password matches after retry.
                    return ob;
                } else if (i == 2) {  // if failed 3 times.
                    return new Admininfo(null, null);  // return a blank admin object.
                }}}
            }
        }


        return null;  // if admin not found or password incorrect.
    }

    




    // this method shows the current available notes in the atm.
    public static void currentnotes() {
        for (Notes n : ATM.getCurrencynotes()) {  // loop through all notes.
            System.out.println(n.getNotes() + " " + n.getCount());  // print note and its count.
        }
    }

}
