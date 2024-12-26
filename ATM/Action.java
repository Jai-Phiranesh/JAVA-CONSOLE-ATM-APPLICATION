
import java.util.Scanner;

public class Action {
    
    public static Object login(String choice,Scanner ob) throws CloneNotSupportedException {
        System.out.println("Enter the user name: ");
        String inu = ob.nextLine();
        
        if (choice.equals("admin")) {

           Admininfo Ao= ATMActions.checkadmin(inu,ob );
           
           return Ao;
        } else {

            Userinfo uo=ATMActions.checkuser(inu, ob);
            return uo;

        }
    }

    public void adduser(Scanner ob) {

    }

    public void deleteuser(Scanner ob) {

    }

    public void viewalluser() {

    }

    public void viewalltransaction(Scanner ob) {

    }

    public void depositcash(Admininfo aob,Scanner ob) {

    }

    public void userdepositcash(Userinfo cub,Scanner scob) {

    }

    public void checkbalance(Userinfo cub) {

    }

    public void withdrawcash(Userinfo cub,Scanner scob) throws CloneNotSupportedException {

    }

    public void changepin(Userinfo cub,Scanner scob) {

    }

    public void userTransaction(Userinfo cub) {

    }

}