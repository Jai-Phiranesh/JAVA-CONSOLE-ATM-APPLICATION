package ATM;
import java.util.ArrayList;

import ATM.Listofnotes.*;
import ATM.Note.Note;

public class ATM {  // atm pojo class handle the fields
    private static ArrayList<Account> accountlist = new ArrayList<>();  // list to store all users.
    // list to store all admins.
    //private static ArrayList<Note> currencynotes = new ArrayList<Note>();  // list to store available currency notes.
   // list to store all transactions.

    private static double atmcash;  // variable to store the total cash available in the ATM.

    private static Notes<Note>  notesarray= new Notes<>();
    public static Notes<Note> getNotesarray() {
        return notesarray;
    }
    // this method initializes the currency notes in the ATM with 0 count for each denomination.
    public static void iniCurrencynotes() {
        Note o1 = new Ru2000(0, "2000");  // create a note of 2000.
        Note o2 = new Ru500(0, "500");  // create a note of 500.
        Note o3 = new Ru200(0, "200");  // create a note of 200.
        Note o4 = new Ru100(0, "100");  // create a note of 100.
        // currencynotes.add(o1);  // add the 2000 note to the list.
        // currencynotes.add(o2);  //similar to 2000
        // currencynotes.add(o3);  //similar to 2000
        // currencynotes.add(o4);  //similar to 2000
       
        notesarray.add(o1);
        notesarray.add(o2);
        notesarray.add(o3);
        notesarray.add(o4);

        

        
    }

    // allows you to update the currency notes list.
    public static void setCurrencynotes(Notes<Note> upcurrencynotes) {
        ATM.notesarray = upcurrencynotes;  // set the new currency notes list.
    }

    public static ArrayList<Account> getAccountlist() {
        return accountlist;
    }

    // returns the total ATM cash.
    public static double getatmcash() {
        return atmcash;
    }

    // sets the total ATM cash.
    public static void setatmcash(double d) {
        atmcash = d;  // update the total cash in the ATM.
    }


    // returns the list of available currency notes in the ATM.
    public static Notes<Note> getCurrencynotes() {
        return notesarray;
    }

    // this method returns a user's current object based on their username.
    public Userinfo getusercurrentOb(String name) {
        for (Account cru : ATM.getAccountlist()) {
            if(cru instanceof Userinfo ){
               // loop through all users.
            if (name.equals(cru.getId())) {  // if the username matches.
                return (Userinfo)cru;  // return the user object.
            }
        }}
        return null;  // if user is not found, return null.



    }}
