import java.util.Scanner;

public class Adminaction extends Action {

    public static void operations(Admininfo aob, Adminaction aao, Scanner ob) {
        while (true) {
            System.out.println(
                    "\n1. Add User\n2. View All user\n3. Deleteuser\n4. view All Transaction\n5. Deposit cash in ATM\n6. Exit:");
            String uc = ob.nextLine();
            int ucho = Integer.parseInt(uc);
            switch (ucho) {
                case 1:
                    aao.adduser(ob);

                    break;
                case 2:
                    aao.viewalluser();

                    break;

                case 3:
                    aao.deleteuser(ob);
                    break;

                case 4:
                    aao.viewalltransaction(ob);
                    break;

                case 5:
                    aao.depositcash(aob, ob);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("INVALID input:");
            }
        }
    }

    @Override
    public void adduser(Scanner ob) {
        Userinfo currentuser;
        j: while (true) {
            System.out.println("Enter The Userid To Add Or 1 To Exit:");

            String inu = ob.nextLine();
            if (inu.equals("1")) {
                break j;
            }
            for (Userinfo everyuser : ATM.getUserlist()) {
                String check = everyuser.getUser();
                if (inu.equals(check)) {
                    System.out.println("user already exits try again:");
                    continue j;
                }
            }

            System.out.println("Enter the password to add:");

            String inp = ob.nextLine();
            Userinfo ub = new Userinfo(inu, inp);
            currentuser = ub;
            ATM.setArr((ub));
            System.out.println("Successfully added the userid and password:" + currentuser.toString());
            break j;
        }
    }

    @Override
    public void viewalluser() {
        System.out.println("All the users are: ");
        for (Userinfo everyuser : ATM.getUserlist()) {
            System.out.println(everyuser.getUser());
        }

    }

    @Override
    public void deleteuser(Scanner ob) {
        System.out.println("Enter the userid to delete ");
        int index = -1;
        String inu = ob.nextLine();

        for (Userinfo everyuser : ATM.getUserlist()) {
            if (everyuser.getUser().equals(inu)) {
                index = ATMActions.index(everyuser);
                System.out.println("Removed user successfully" + everyuser.getUser());

            }

        }
        if (index != -1) {
            ATM.getUserlist().remove(index);
        }
    }

    @Override
    public void viewalltransaction(Scanner ob) {
        System.out.println("\n1.For specific user \n2.for all user \n3.Admin Transactions");
        String uc = ob.nextLine();
        if (uc.equals("1")) {
            System.out.println("Enter the user to view history:");
            String ucu = ob.nextLine();
            for (Transaction et : ATM.getTransaction()) {
                String check = et.getUser();
                if (ucu.equals(check)) {
                    System.out.println("The Transaction history of  " + ucu + "  is:");
                    System.out.println(et.getType() + "  by  " + et.getUser() + "  Amount is  " + et.getAmount());

                } else {
                    System.out.println("");
                }
            }

        } else if (uc.equals("2")) {
            System.out.println("All the users transactions  are: ");
            for (Transaction et : ATM.getTransaction()) {
                if (et.getUser().equals("Admin")) {

                } else {
                    System.out.println(et.getType() + "  by  " + et.getUser() + "  Amount is  " + et.getAmount());
                }

            }
        } else if (uc.equals("3")) {
            System.out.println("All the Admin transactions  are: ");
            for (Transaction et : ATM.getTransaction()) {
                if (et.getUser().equals("Admin")) {

                    System.out.println(et.getType() + " by  " + et.getUser() + "  Amount is  " + et.getAmount());
                } else {

                }

            }
        } else {
            System.out.println("INVALID INPUT TRY AGAIN");
        }

    }

    @Override
    public void depositcash(Admininfo aob, Scanner ob) {
        System.out.println("\n" + "Enter The Amount To Deposit In The ATM: " + "\n");
        System.out.println("Enter the Amount:");
        String inamo = ob.nextLine();

        System.out.println("Enter The Number Of 2000 Notes: ");

        long cash2000 = Long.parseLong(ob.nextLine());

        System.out.println("The Amount Of 2000 Notes IS :" + cash2000 * 2000 + "\n");

        System.out.println("Enter The Number Of 500 Notes: ");

        long cash500 = Long.parseLong(ob.nextLine());

        System.out.println("The Amount Of 500 Notes IS :" + cash500 * 500 + "\n");

        System.out.println("Enter The Number Of 200 Notes: ");

        long cash200 = Long.parseLong(ob.nextLine());

        System.out.println("The Amount Of 200 Notes IS :" + cash200 * 200 + "\n");

        System.out.println("Enter The Number Of 100 Notes: ");

        long cash100 = Long.parseLong(ob.nextLine());

        System.out.println("The Amount Of 100 Notes IS :" + cash100 * 100 + "\n");

        double cash = cash2000 * 2000 + cash500 * 500 + cash200 * 200 + cash100 * 100;
        if (Double.parseDouble(inamo) == cash) {
           
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
            ATMActions.updateatmcash();
            System.out.println("TOtal Deposited Amount is:" + ATM.getatmcash() + "\n");
            //transaction
            Transaction tb = new Transaction("Deposit", cash, aob);
            ATM.getTransaction().add(tb);
            ATMActions.currentnotes();

        } else {
            System.out.println("DENOMINATION AND AMOUNT NOT MATCH:");
        }

    }
}
