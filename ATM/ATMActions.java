
import java.util.Scanner;

public class ATMActions {
    static void start() throws CloneNotSupportedException {
        ATM.iniCurrencynotes();

        ATM: while (true) {
            System.out.println("Enter The Choice admin Or user Or Exit: ");

            Scanner sob = new Scanner(System.in);
            String in = sob.nextLine();
            Admininfo oba = new Admininfo();
            Useraction uaob= new Useraction();
            Adminaction aaob=new Adminaction();
            ATM.setAdminlist(oba);
            
            

            if (in.equals("user")) {
                Userinfo u =(Userinfo) Action.login("user",sob);
                if(u==null){
                    System.out.println("No Users Found");
                }
                else if(u.getThreat()==true){
                    System.out.println("Wrong password");
                }
                else{
                    Useraction.operations(u, uaob,sob);
                }

            } else if (in.equals("admin")) {
                ATM.setAdminlist(oba);
                Admininfo a = (Admininfo)Action.login("admin",sob);
                if(a==null){
                    System.out.println("No Users Found");
                }
                else if(a.getUser()==null){
                    System.out.println("Wrong password");
                }
                else{
                    Adminaction.operations(a, aaob,sob);
                }
            } else if (in.equals("exit")) {
                break ATM;
            } else {
                System.out.println("INVALID INPUT:");
            }

        }
    }

    public static void updateatmcash() {
        String no100 = "100";
        String no500 = "500";
        String no200 = "200";
        String no2000 = "2000";
        long cur2000 = 0;
        long cur500 = 0;
        long cur200 = 0;
        long cur100 = 0;
        for (Notes n : ATM.getCurrencynotes()) {
            if (no100.equals(n.getNotes())) {
                cur100 = n.getCount();
            } else if (no500.equals(n.getNotes())) {
                cur500 = n.getCount();
            } else if (no200.equals(n.getNotes())) {
                cur200 = n.getCount();
            } else if (no2000.equals(n.getNotes())) {
                cur2000 = n.getCount();
            }

        }

        double atmcash = cur2000 * 2000 + cur500 * 500 + cur200 * 200 + cur100 * 100;
        ATM.setatmcash(atmcash);
    }

    public static Userinfo checkuser(String id, Scanner sob) throws CloneNotSupportedException {
       
        for (Userinfo ob : ATM.getUserlist()) {
            if (id.equals(ob.getUser())) {

                System.out.println("Enter the password :");
                String inp = sob.nextLine();
                for (int i = 0; i < 3; i++) {
                    if (inp.equals(ob.getPass())) {

                        return ob;

                    } else {
                        System.out.println("Wrong pass try again :");
                        inp = sob.nextLine();
                        if (inp.equals(ob.getPass())) {
                            return ob;

                        } else if (i == 2) {
                            
                            return new Userinfo(null,null);
                        }
                    }
                }
            } 
                
            
        }
        return null;
    }

    
    public static Admininfo checkadmin(String id, Scanner sob) throws CloneNotSupportedException {
       
        for (Admininfo ob : ATM.getAdminlist()) {
            if (id.equals(ob.getUser())) {

                System.out.println("Enter the password :");
                String inp = sob.nextLine();
                for (int i = 0; i < 3; i++) {
                    if (inp.equals(ob.getPass())) {

                        return ob;

                    } else {
                        System.out.println("Wrong pass try again :");
                        inp = sob.nextLine();
                        if (inp.equals(ob.getPass())) {
                            return ob;

                        } else if (i == 2) {
                            return new Admininfo(null,null);
                            
                        }
                    }
                }
            } 
                
            
        }
        return null;
    }

    public static int index(Userinfo ob) {
        int in = ATM.getUserlist().indexOf(ob);
        return in;

    }

    @Override
    public String toString() {
        return "ATMActions []";
    }
    public static void currentnotes(){
        for(Notes n:ATM.getCurrencynotes()){
            System.out.println(n.getNotes()+" "+n.getCount());
        }
    }

}
