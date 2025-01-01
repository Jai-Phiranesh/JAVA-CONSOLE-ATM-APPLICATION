import java.util.Scanner;

public class Adminaction extends Action {

    // Main operations for the admin like adding, deleting users, etc.
    public static void operations(Admininfo aob, Adminaction aao, Scanner ob) {
        while (true) {
            // Display admin menu options
            System.out.println("\n1. Add User\n2. View All user\n3. Delete user\n4. view All Transaction\n5. Deposit cash in ATM\n6. Exit:");
            String uc = ob.nextLine();
            int ucho = Integer.parseInt(uc);
            switch (ucho) {
                case 1: aao.adduser(ob); break;  // Call add user
                case 2: aao.viewalluser(); break;  // View all users
                case 3: aao.deleteuser(ob); break;  // Delete user
                case 4: aao.viewalltransaction(ob); break;  // View transactions
                case 5: aao.depositcash(aob, ob); break;  // Deposit cash in ATM
                case 6: return;  // Exit
                default: System.out.println("INVALID input:");  // Invalid input
            }
        }
    }

    // Add a new user to the system
    @Override
    public void adduser(Scanner ob) {
        Userinfo currentuser;
        j: while (true) {
            System.out.println("Enter The Userid To Add Or 1 To Exit:");
            String inu = ob.nextLine();
            if (inu.equals("1")) break j;  // Exit option
            // Check if user already exists
            for (Userinfo everyuser : ATM.getUserlist()) {
                if (inu.equals(everyuser.getUser())) {
                    System.out.println("user already exists, try again:");
                    continue j;
                }
            }
            // Create new user
            System.out.println("Enter the password to add:");
            String inp = ob.nextLine();
            Userinfo ub = new Userinfo(inu, inp);
            currentuser = ub;
            ATM.setArr(ub);  // Add to user list
            System.out.println("Successfully added the userid and password:" + currentuser.toString());
            break j;
        }
    }

    // View all users in the system
    @Override
    public void viewalluser() {
        System.out.println("All the users are: ");
        for (Userinfo everyuser : ATM.getUserlist()) {
            System.out.println(everyuser.getUser());  // Display each user's username
        }
    }

    // Delete a user from the system
    @Override
    public void deleteuser(Scanner ob) {
        System.out.println("Enter the userid to delete ");
        int index = -1;
        String inu = ob.nextLine();

        for (Userinfo everyuser : ATM.getUserlist()) {
            if (everyuser.getUser().equals(inu)) {
                index = ATMActions.index(everyuser);  // Find the user index
                System.out.println("Removed user successfully " + everyuser.getUser());
            }
        }
        if (index != -1) {
            ATM.getUserlist().remove(index);  // Remove user from the list
        }
    }

    // View all transactions or specific user transactions
    @Override
    public void viewalltransaction(Scanner ob) {
        System.out.println("\n1.For specific user \n2.for all user \n3.Admin Transactions");
        String uc = ob.nextLine();
        if (uc.equals("1")) {
            // Show specific user transactions
            if (ATM.getTransaction().isEmpty()) {
                System.out.println("No Transactions..");
            }
            System.out.println("Enter the user to view history:");
            String ucu = ob.nextLine();
            for (Transaction et : ATM.getTransaction()) {
                if (ucu.equals(et.getUser())) {
                    System.out.println(et.getType() + "  by  " + et.getUser() + "  Amount is  " + et.getAmount());
                }
            }
        } else if (uc.equals("2")) {
            // Show all users transactions
            if (ATM.getTransaction().isEmpty()) {
                System.out.println("No Transactions..");
            }
            for (Transaction et : ATM.getTransaction()) {
                if (!et.getUser().equals("Admin")) {
                    System.out.println(et.getType() + "  by  " + et.getUser() + "  Amount is  " + et.getAmount());
                }
            }
        } else if (uc.equals("3")) {
            // Show only admin transactions
            System.out.println("All the Admin transactions  are: ");
            for (Transaction et : ATM.getTransaction()) {
                if (et.getUser().equals("Admin")) {
                    System.out.println(et.getType() + " by  " + et.getUser() + "  Amount is  " + et.getAmount());
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
            Transaction tb = new Transaction("Deposit", cash, aob);
            ATM.getTransaction().add(tb);  // Add the transaction
            ATMActions.currentnotes();  // Show updated notes count
        } else {
            System.out.println("DENOMINATION AND AMOUNT NOT MATCH:");
        }
    }
}
