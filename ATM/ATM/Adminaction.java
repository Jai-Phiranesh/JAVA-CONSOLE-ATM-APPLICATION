package ATM;

import java.util.Scanner;


import ATM.Actions.AdminActions;
import ATM.Notes.Notes;

public class Adminaction extends Action implements AdminActions {
    public static Scanner scanner= new Scanner(System.in);

   

    // Add a new user to the system
    @Override
    public void adduser() {
       
        j:
        while (true) {
            System.out.println("Enter The Userid To Add Or 1 To Exit:");
            String inputUserID = scanner.nextLine();
            if (inputUserID.equals("1")) break j;  // Exit option
            // Check if user already exists
            for (Account everyuser : ATM.getAccountlist()) {
                if (everyuser instanceof Userinfo) {

                    if (inputUserID.equals(everyuser.getId())) {
                        System.out.println("user already exists, try again:");
                        continue j;
                    }
                }
            }
            // Create new user
            System.out.println("Enter the password to add:");
            String inputPassword = scanner.nextLine();
           
            ATM.getAccountlist().add(new Userinfo(inputUserID, inputPassword, 0));  // Add to user list

            System.out.println("Successfully added the userid and password:" + inputUserID);
            break j;
        }
    }

    // View all users in the system
    @Override
    public void viewalluser() {
        System.out.println("All the users are: ");
        for (Account everyuser : ATM.getAccountlist()) {
            if (everyuser instanceof Userinfo) {


                System.out.println(everyuser.getId());

            }
        }
    }

    // Delete a user from the system
    @Override
    public void deleteuser() {
        System.out.println("Enter the userid to delete ");
        
        String inuputUserID = scanner.nextLine();

        for (Account everyuser : ATM.getAccountlist()) {
            if (everyuser instanceof Userinfo) {
                if(everyuser.getId().equals(inuputUserID)){

               
                ATM.getAccountlist().remove(ATM.getAccountlist().indexOf(everyuser));
                System.out.println("Removed user successfully " + everyuser.getId());
                return;
            }}
           
               
            
        } System.out.println("No user....");
      
    }

    // View all transactions or specific user transactions
    @Override
    public void viewtransaction( Account account) {
        System.out.println("\n1.For specific user \n2.for all user \n3.Admin Transactions");
        String adminChoice = scanner.nextLine();
        Admininfo adminObject= null;
        if(account instanceof Admininfo){
             adminObject=(Admininfo)account;
        }

        if (adminChoice.equals("1")) {
            // Show specific user transactions

            System.out.println("Enter the user to view history:");
            String userId = scanner.nextLine();
            for (Account ch : ATM.getAccountlist()) {
                if (ch instanceof Userinfo) {
                    if (ch.getId().equals(userId)) {
                        if (ch.getTransaction().isEmpty()) {
                            System.out.println("No Transaction");
                            return;
                        }
                        for (Transaction et : ch.getTransaction()) {


                            System.out.println(et.getType() + "  by  " + et.getUser() + "  Amount is  " + et.getAmount());

                        }
                    }
                    else{
                        System.out.println("No Users");
                    }
                }
            }
        } else if (adminChoice.equals("2")) {
            // Show all users transactions
            System.out.println("All the User transactions  are: ");
            for (Account ch : ATM.getAccountlist()) {
                if (ch instanceof Userinfo) {
                    for (Transaction et : ch.getTransaction()) {

                        System.out.println(et.getType() + "  by  " + et.getUser() + "  Amount is  " + et.getAmount());

                    }
                }
            }
        } else if (adminChoice.equals("3")) {
            // Show only admin transactions


            System.out.println("All the Admin transactions  are: ");
            for (Account ch : ATM.getAccountlist()) {
                if (ch instanceof Admininfo) {
                    for (Transaction et : adminObject.getTransaction()) {

                        System.out.println(et.getType() + " by  " + et.getUser() + "  Amount is  " + et.getAmount());

                    }
                }
            }
        } else {
            System.out.println("INVALID INPUT TRY AGAIN");
        }
    }

    // Deposit cash into the ATM
    @Override
    public void depositcash(Account account) {

        Admininfo adminObject= null;
        if(account instanceof Admininfo){
             adminObject=(Admininfo)account;
        }
        System.out.println("\nEnter The Amount To Deposit In The ATM:");
        System.out.println("Enter the Amount:");
        String inamo = scanner.nextLine();

        // Enter the number of notes for each denomination
        System.out.println("Enter The Number Of 2000 Notes: ");
        long cash2000 = Long.parseLong(scanner.nextLine());

        System.out.println("The Amount Of 2000 Notes IS :" + cash2000 * 2000);
        System.out.println("Enter The Number Of 500 Notes: ");
        long cash500 = Long.parseLong(scanner.nextLine());

        System.out.println("The Amount Of 500 Notes IS :" + cash500 * 500);
        System.out.println("Enter The Number Of 200 Notes: ");
        long cash200 = Long.parseLong(scanner.nextLine());

        System.out.println("The Amount Of 200 Notes IS :" + cash200 * 200);
        System.out.println("Enter The Number Of 100 Notes: ");
        long cash100 = Long.parseLong(scanner.nextLine());

        System.out.println("The Amount Of 100 Notes IS :" + cash100 * 100);

        // Check if the total matches the expected amount
        double cash = cash2000 * 2000 + cash500 * 500 + cash200 * 200 + cash100 * 100;
        if (Double.parseDouble(inamo) == cash) {
            // Update the ATM with the new cash amounts
            for (Notes note : ATM.getCurrencynotes()) {
                switch (note.getNotes()) {
                    case "2000":
                        note.setCount(note.getCount() + cash2000);  // Update 2000 notes count
                        break;
                    case "500":
                        note.setCount(note.getCount() + cash500);  // Update 500 notes count
                        break;
                    case "200":
                        note.setCount(note.getCount() + cash200);  // Update 200 notes count
                        break;
                    case "100":
                        note.setCount(note.getCount() + cash100);  // Update 100 notes count
                        break;
                    default:
                        break;
                }
            }
            ATMActions.updateatmcash();  // Update ATM cash
            System.out.println("Total Deposited Amount is:" + ATM.getatmcash());

            // Log the deposit transaction
            Transaction tb = new Transaction("Deposit", cash, adminObject.getId());
            adminObject.getTransaction().add(tb);  // Add the transaction
            ATMActions.currentnotes();  // Show updated notes count
        } else {
            System.out.println("DENOMINATION AND AMOUNT NOT MATCH:");
        }
    }

    public void atmBalance(){
        System.out.println(ATM.getatmcash());
    }
}
