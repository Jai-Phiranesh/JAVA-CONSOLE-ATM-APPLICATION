package ATM;

import java.util.Scanner;

import ATM.Notes.Notes;

public class Adminaction extends Action {

    // Main operations for the admin like adding, deleting users, etc.
    public static void operations(Admininfo aob, Adminaction aao, Scanner ob) {
        while (true) {
            // Display admin menu options
            System.out.println("\n1. Add User\n2. View All user\n3. Delete user\n4. view All Transaction\n5. Deposit cash in ATM\n6. Exit:");
            String uc = ob.nextLine();
            int ucho = Integer.parseInt(uc);
            switch (ucho) {
                case 1:
                    aao.adduser(ob);
                    break;  // Call add user
                case 2:
                    aao.viewalluser();
                    break;  // View all users
                case 3:
                    aao.deleteuser(ob);
                    break;  // Delete user
                case 4:
                    aao.viewalltransaction(ob, aob);
                    break;  // View transactions
                case 5:
                    aao.depositcash(aob, ob);
                    break;  // Deposit cash in ATM
                case 6:
                    return;  // Exit
                default:
                    System.out.println("INVALID input:");  // Invalid input
            }
        }
    }

    // Add a new user to the system
    @Override
    public void adduser(Scanner ob) {
        Account currentuser;
        j:
        while (true) {
            System.out.println("Enter The Userid To Add Or 1 To Exit:");
            String inu = ob.nextLine();
            if (inu.equals("1")) break j;  // Exit option
            // Check if user already exists
            for (Account everyuser : ATM.getAccountlist()) {
                if (everyuser instanceof Userinfo) {

                    if (inu.equals(everyuser.getId())) {
                        System.out.println("user already exists, try again:");
                        continue j;
                    }
                }
            }
            // Create new user
            System.out.println("Enter the password to add:");
            String inp = ob.nextLine();
           
            ATM.getAccountlist().add(new Userinfo(inu, inp, 0));  // Add to user list

            System.out.println("Successfully added the userid and password:" + inu);
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
    public void deleteuser(Scanner ob) {
        System.out.println("Enter the userid to delete ");
        
        String inu = ob.nextLine();

        for (Account everyuser : ATM.getAccountlist()) {
            if (everyuser instanceof Userinfo) {
                if(everyuser.getId().equals(inu)){

               
                ATM.getAccountlist().remove(ATM.getAccountlist().indexOf(everyuser));
                System.out.println("Removed user successfully " + everyuser.getId());
                return;
            }}
           
               
            
        } System.out.println("No user....");
      
    }

    // View all transactions or specific user transactions
    @Override
    public void viewalltransaction(Scanner ob, Admininfo ao) {
        System.out.println("\n1.For specific user \n2.for all user \n3.Admin Transactions");
        String uc = ob.nextLine();

        if (uc.equals("1")) {
            // Show specific user transactions

            System.out.println("Enter the user to view history:");
            String ucu = ob.nextLine();
            for (Account ch : ATM.getAccountlist()) {
                if (ch instanceof Userinfo) {
                    if (ch.getId().equals(ucu)) {
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
        } else if (uc.equals("2")) {
            // Show all users transactions

            for (Account ch : ATM.getAccountlist()) {
                if (ch instanceof Userinfo) {
                    for (Transaction et : ch.getTransaction()) {

                        System.out.println(et.getType() + "  by  " + et.getUser() + "  Amount is  " + et.getAmount());

                    }
                }
            }
        } else if (uc.equals("3")) {
            // Show only admin transactions


            System.out.println("All the Admin transactions  are: ");
            for (Account ch : ATM.getAccountlist()) {
                if (ch instanceof Admininfo) {
                    for (Transaction et : ao.getTransaction()) {

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
    public void depositcash(Admininfo aob, Scanner ob) {
        System.out.println("\nEnter The Amount To Deposit In The ATM:");
        System.out.println("Enter the Amount:");
        String inamo = ob.nextLine();

        // Enter the number of notes for each denomination
        System.out.println("Enter The Number Of 2000 Notes: ");
        long cash2000 = Long.parseLong(ob.nextLine());

        System.out.println("The Amount Of 2000 Notes IS :" + cash2000 * 2000);
        System.out.println("Enter The Number Of 500 Notes: ");
        long cash500 = Long.parseLong(ob.nextLine());

        System.out.println("The Amount Of 500 Notes IS :" + cash500 * 500);
        System.out.println("Enter The Number Of 200 Notes: ");
        long cash200 = Long.parseLong(ob.nextLine());

        System.out.println("The Amount Of 200 Notes IS :" + cash200 * 200);
        System.out.println("Enter The Number Of 100 Notes: ");
        long cash100 = Long.parseLong(ob.nextLine());

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
            Transaction tb = new Transaction("Deposit", cash, aob.getId());
            aob.getTransaction().add(tb);  // Add the transaction
            ATMActions.currentnotes();  // Show updated notes count
        } else {
            System.out.println("DENOMINATION AND AMOUNT NOT MATCH:");
        }
    }
}
