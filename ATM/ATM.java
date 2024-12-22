
import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
    public static ArrayList<Userinfo> userlist=new ArrayList<Userinfo>();
    public static void  setArr(Userinfo ob){
        userlist.add(ob);

    }
    public static ArrayList<Userinfo>  getArr(){
        return userlist;

    }
    public static int index(Userinfo ob){
        int in=userlist.indexOf(ob);
        return in;

    }
    static void start(){
        //Useraction ub = new Useraction();
           
         
        System.out.println("WELCOME");
        ATM:while(true){
            System.out.println("Enter the admin or user or exit ");
            Scanner ob=new Scanner(System.in);
            String in=ob.nextLine();
            if(in.equals("user")){
                Useraction.login();

            }
            else if(in.equals("admin")){
                Adminaction.login();
            }
            else if(in.equals("exit")){
                break ATM;
            }
            
        }
    }
}
