import java.util.ArrayList;
import java.util.Scanner;

public class Useraction extends Action {

    public static void operations(Userinfo cub, Useraction uao, Scanner scob) throws CloneNotSupportedException {
        while (true) {
            System.out.println(
                    "\n1. Check Balance\n2. Withdrw Cash\n3. Deposit Cash\n4. Change Pin\n5. Transaction\n6. Exit:");
            String uc = scob.nextLine();
            int ucho = Integer.parseInt(uc);
            switch (ucho) {
                case 1:
                    uao.checkbalance(cub);

                    break;
                case 2:
                    uao.withdrawcash(cub, scob);

                    break;

                case 3:
                    uao.userdepositcash(cub, scob);
                    break;

                case 4:
                    uao.changepin(cub, scob);

                    break;
                case 5:
                    uao.userTransaction(cub);
                    break;
                case 6:
                    return;

                default:
                    System.out.println("INVALID input:");
            }
        }
    }

    @Override
    public void checkbalance(Userinfo cub) {
        System.out.println("YOUR BALANCE IS:" + cub.getBalance());

    }

    public long performwithdraw(ArrayList<String> d, Notes note, long useramount) {
        long notety = Long.parseLong(note.getNotes());
        long count = useramount / notety;

        if (notety <= useramount && count <= note.getCount()) {
            useramount -= count * notety;
            note.setCount(note.getCount() - count);
            d.add("THE NOTES YOU GOT ARE" + notety + "count is" + count);
            return useramount;

        }
        return useramount;
    }

    @Override
    public void withdrawcash(Userinfo cub, Scanner scob) throws CloneNotSupportedException {
        System.out.println("Enter The Amount To  Withdraw:" + "\n");

        long amount = Long.parseLong(scob.nextLine());
        long famount = amount;

        if (amount > ATM.getatmcash()) {
            System.out.println("INSUFFICIENT BALANCE IN ATM");
        }
        if (amount > cub.getBalance()) {
            System.out.println("INSUFFIENT BALANCE IN YOUR BANK ACCOUNT DEPOSIT TO WITHDRAW");
        }

        else {
            ArrayList<Notes> duplicate = new ArrayList<>();
            ArrayList<String> DENOMINATION = new ArrayList<>();
            for (Notes n : ATM.getCurrencynotes()) {
                duplicate.add(n.clone());
            }
            while (amount != 0) {

                for (Notes note : duplicate) {
                    String type = note.getNotes();
                    switch (type) {
                        case "2000", "500", "200", "100":
                            amount = performwithdraw(DENOMINATION, note, amount);
                            break;

                    }

                }
                if (amount == 0) {

                    for (String i : DENOMINATION) {
                        System.out.println(i);
                    }
                    System.out.println("WITHDRAWL SUCCESS");
                    ATM.setCurrencynotes(duplicate);
                    ATMActions.updateatmcash();
                    Transaction tb = new Transaction("withdraw", famount, cub);
                    ATM.getTransaction().add(tb);
                    cub.setBalance(cub.getBalance() - famount);
                    System.out.println("YOUR BALANCE IS:" + cub.getBalance());
                    ATMActions.currentnotes();
                    break;

                } else {

                    System.out.println("ENTER OTHER AMOUNT DENOMINATIONS DOES NOT MATCH");
                    break;
                }
            }

        }

    }

    @Override
    public void userdepositcash(Userinfo cub, Scanner scob) {
        System.out.println("Enter The Amount To  Deposit:" + "\n");

        String inamo = scob.nextLine();

        System.out.println("Enter The Number Of 2000 Notes: ");
        long cash2000 = Long.parseLong(scob.nextLine());
        System.out.println("The Amount Of 2000 Notes IS :" + cash2000 * 2000 + "\n");

        System.out.println("Enter The Number Of 500 Notes: ");
        long cash500 = Long.parseLong(scob.nextLine());
        System.out.println("The Amount Of 500 Notes IS :" + cash500 * 500 + "\n");

        System.out.println("Enter The Number Of 200 Notes: ");
        long cash200 = Long.parseLong(scob.nextLine());
        System.out.println("The Amount Of 200 Notes IS :" + cash200 * 200 + "\n");

        System.out.println("Enter The Number Of 100 Notes: ");
        long cash100 = Long.parseLong(scob.nextLine());
        System.out.println("The Amount Of 100 Notes IS :" + cash100 * 100 + "\n");

        double amo = cash2000 * 2000 + cash500 * 500 + cash200 * 200 + cash100 * 100;

        if (amo == Double.parseDouble(inamo)) {
            System.out.println("Amount Deposited  successfully:" + amo + "\n");

            cub.setBalance(cub.getBalance() + amo);
            System.out.println("Current balance is:" + cub.getBalance());
            Transaction tb = new Transaction("Deposit", amo, cub);
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
            ATM.getTransaction().add(tb);
            ATMActions.updateatmcash();
        }

        else {
            System.out.println("DENOMINATION DOES NOT MATCH:");
        }

    }

    @Override
    public void changepin(Userinfo cub, Scanner scob) {
        System.out.println("Enter the password once again to change password:");
        String inp = scob.nextLine();
        if (inp.equals(cub.getPass())) {
            System.out.println("Enter the New Password:");
            String innp = scob.nextLine();
            cub.setPass(innp);
            System.out.println("Password changed successfully..." + innp);

        } else {
            System.out.println("Wrong password...");
        }

    }

    @Override
    public void userTransaction(Userinfo cub) {
        System.out.println("YOUR TRANSACTIONS ARE:");
        int i = 1;
        for (Transaction et : ATM.getTransaction()) {
            String check = et.getUser();
            if (cub.getUser().equals(check)) {

                System.out.println(i + " " + et.getType() + "  by  " + "you" + "  Amount is  " + et.getAmount());
            }

        }
    }
}
