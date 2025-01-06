package ATM;

import java.util.ArrayList;

public class Account {
    private final String id;
    private String password;

    private final ArrayList<Transaction> transaction = new ArrayList<Transaction>();

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    protected Account(String id,String pss){
        this.id=id;
        this.password=pss;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  ArrayList<Transaction> getTransaction() {
        return transaction;
    }
}
