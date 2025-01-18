package ATM;
import ATM.Actions.UserActions;
import ATM.Notes.Notes;

import java.util.*;
public class Useraction extends Action implements UserActions {
    
    // This method controls the menu and user actions like balance checking etc..
   

    // Display user's current balance
    @Override
    public void checkbalance(Userinfo currentUser) {
        System.out.println("YOUR BALANCE IS:" + currentUser.getBalance());
    }

    // Process withdrawal for each denomination in the ATM
    public long performwithdraw(ArrayList<String> withdrawNotesCount, Notes note, long useramount) {
        long notety = Long.parseLong(note.getNotes());  // Get the denomination
        long count = useramount / notety;  // Calculate the number of notes required
        
        if (notety <= useramount && 0 < note.getCount()) {
            if (count <= note.getCount()) {
                useramount -= count * notety;  // Reduce the withdrawal amount
                note.setCount(note.getCount() - count);  // Update the note count in ATM
                withdrawNotesCount.add("THE NOTES YOU GOT ARE " + notety + " count is " + count);  // Log withdrawal details
                return useramount;
            } else {
                useramount -= notety * note.getCount();  // If more notes needed than available
                withdrawNotesCount.add("THE NOTES YOU GOT ARE " + notety + " count is " + note.getCount());
                note.setCount(0);  // Update the note count to 0
                return useramount;
            }
        }
        return useramount;  // Return remaining amount
    }

    // Main function to handle cash withdrawal
    @Override
    public void withdrawcash(Userinfo currentUser) throws CloneNotSupportedException {
        System.out.println("Enter The Amount To Withdraw:");
        long amount = Long.parseLong(scanner.nextLine());
        long finalamount = amount;  // Store the requested amount

        // Check if ATM has sufficient funds and if user has enough balance
        if (amount > ATM.getatmcash()) {
            System.out.println("INSUFFICIENT BALANCE IN ATM");
            return;
        }
        if (amount > currentUser.getBalance()) {
            System.out.println("INSUFFICIENT BALANCE IN YOUR BANK ACCOUNT");
        }
         else {
            ArrayList<Notes> duplicate = new ArrayList<>();
            ArrayList<String> withdrawNotesCount = new ArrayList<>();
            for (Notes notes : ATM.getCurrencynotes()) {
                duplicate.add(notes.clone());  // Clone ATM notes for safe manipulation
            }

            // Process withdrawal while amount is still pending
            if (amount != 0) {
                for (Notes note : duplicate) {
                    String type = note.getNotes();  // Get current note type
                    switch (type) {
                        case "2000", "500", "200", "100":
                            amount = performwithdraw(withdrawNotesCount, note, amount);  // Withdraw using the specific note denomination
                            break;
                    }
                }

                if (amount == 0) {  // Successfully withdrawn all funds
                    for (String i : withdrawNotesCount) {
                        System.out.println(i);  // Print withdrawn denominations
                    }
                    System.out.println("WITHDRAWAL SUCCESS");
                    ATM.setCurrencynotes(duplicate);  // Update ATM notes after withdrawal
                    ATMActions.updateatmcash();  // Update ATM cash
                    Transaction tb = new Transaction("withdraw", finalamount, currentUser.getId());  // Log the transaction
                    currentUser.getTransaction().add(tb);  // Add transaction to global list
                    currentUser.setBalance(currentUser.getBalance() - finalamount);  // Deduct from user balance
                    System.out.println("YOUR BALANCE IS:" + currentUser.getBalance());
                    ATMActions.currentnotes();  // Show updated ATM notes
                    return;
                } else {
                    System.out.println("ENTER OTHER AMOUNT DENOMINATIONS DOES NOT MATCH");
                    return;
                }
            }
        }
    }

    // Handle user cash deposit
    @Override
    public void depositcash(Account account) {
        Userinfo currentUser= null;
        if(account instanceof Userinfo){
             currentUser=(Userinfo)account;
        }
        System.out.println("Enter The Amount To Deposit:");
        String inputamount = scanner.nextLine();

        // Collect note counts from user
        System.out.println("Enter The Number Of 2000 Notes: ");
        long cash2000 = Long.parseLong(scanner.nextLine());
        System.out.println("The Amount Of 2000 Notes IS: " + cash2000 * 2000);

        System.out.println("Enter The Number Of 500 Notes: ");
        long cash500 = Long.parseLong(scanner.nextLine());
        System.out.println("The Amount Of 500 Notes IS: " + cash500 * 500);

        System.out.println("Enter The Number Of 200 Notes: ");
        long cash200 = Long.parseLong(scanner.nextLine());
        System.out.println("The Amount Of 200 Notes IS: " + cash200 * 200);

        System.out.println("Enter The Number Of 100 Notes: ");
        long cash100 = Long.parseLong(scanner.nextLine());
        System.out.println("The Amount Of 100 Notes IS: " + cash100 * 100);

        // Calculate total deposit amount
        double amount = cash2000 * 2000 + cash500 * 500 + cash200 * 200 + cash100 * 100;

        if (amount == Double.parseDouble(inputamount)) {
            // Deposit successful, update user balance
            System.out.println("Amount Deposited successfully: " + amount);
            currentUser.setBalance(currentUser.getBalance() + amount);
            System.out.println("Current balance is: " + currentUser.getBalance());

            // Update ATM notes
            Transaction transaction = new Transaction("Deposit", amount, currentUser.getId());
            for (Notes note : ATM.getCurrencynotes()) {
                String type = note.getNotes();
                switch (type) {
                    case "2000":
                        note.setCount(note.getCount() + cash2000);
                        break;
                    case "500":
                        note.setCount(note.getCount() + cash500);
                        break;
                    case "200":
                        note.setCount(note.getCount() + cash200);
                        break;
                    case "100":
                        note.setCount(note.getCount() + cash100);
                        break;
                    default:
                        break;
                }
            }
            currentUser.getTransaction().add(transaction);  // Log deposit transaction
            ATMActions.updateatmcash();  // Update ATM cash status
        } else {
            System.out.println("DENOMINATION DOES NOT MATCH");
        }
    }

    // Handle change of user PIN
    @Override
    public void changepin(Userinfo currentUSer) {
        System.out.println("Enter the password once again to change password:");
        String inp = scanner.nextLine();
        if (inp.equals(currentUSer.getPassword())) {
            System.out.println("Enter the New Password:");
            String innp = scanner.nextLine();
            currentUSer.setPassword(innp);  // Update the password
            System.out.println("Password changed successfully..." + innp);
        } else {
            System.out.println("Wrong password...");
        }
    }

    // Display user transaction history
    @Override
    public void viewtransaction(Account currentUser) {
        System.out.println("YOUR TRANSACTIONS ARE:");
        int i = 1;
        for (Transaction transaction : currentUser.getTransaction()) {//get the transaction of the current user
            String check = transaction.getUser();
            Account cub1=(Account)currentUser;
            if (cub1.getId().equals(check)) {
                System.out.println(i + " " + transaction.getType() + " by " + "you" + " Amount is " + transaction.getAmount());
            }
        }
    }
}
