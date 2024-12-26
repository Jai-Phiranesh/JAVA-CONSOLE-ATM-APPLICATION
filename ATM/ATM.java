
import java.util.ArrayList;

public class ATM {
    private static ArrayList<Userinfo> userlist = new ArrayList<Userinfo>();
    private static ArrayList<Admininfo> adminlist = new ArrayList<Admininfo>();
    private static ArrayList<Notes> currencynotes = new ArrayList<Notes>();
    private static ArrayList<Transaction> transaction = new ArrayList<Transaction>();

    private static double atmcash;

    public static ArrayList<Admininfo> getAdminlist() {
        return adminlist;
    }

    public static ArrayList<Transaction> getTransaction() {
        return transaction;
    }
    public static void iniCurrencynotes() {
        Notes o1 = new Ru2000(0, "2000");
        Notes o2 = new Ru500(0, "500");
        Notes o3 = new Ru200(0, "200");
        Notes o4 = new Ru100(0, "100");
        currencynotes.add(o1);
        currencynotes.add(o2);
        currencynotes.add(o3);
        currencynotes.add(o4);
    }
    public static void setCurrencynotes(ArrayList<Notes> upcurrencynotes) {
        ATM.currencynotes=upcurrencynotes;
    }

    public static double getatmcash() {
        return atmcash;
    }

    public static void setatmcash(double d) {
        atmcash = d;
    }

    public static void setAdminlist(Admininfo ob) {
        adminlist.add(ob);

    }

    public static void setArr(Userinfo ob) {
        userlist.add(ob);

    }

    public static ArrayList<Notes> getCurrencynotes() {
        return currencynotes;
    }

    public static ArrayList<Userinfo> getUserlist() {
        return userlist;
    }


    public Userinfo getusercurrentOb(String name){
        
        for(Userinfo cru:getUserlist()){
            if(name.equals(cru.getUser())){
                return cru;
            }
      
          
        } return null;
    }

}
