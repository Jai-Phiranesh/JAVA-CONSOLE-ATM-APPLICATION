package ATM;

import java.util.ArrayList;

public class Account {//Account pojo class holds id pass and transactions
    private final String id;// no change in the id so final
    private String password;

    private final ArrayList<Transaction> transaction = new ArrayList<Transaction>();

    public String getId() {//getters 
        return id;
    }

    public String getPassword() {//getters 
        return password;
    }

    protected Account(String id,String password){//construtor and initialize the id nad pass
        this.id=id;
        this.password=password;
    }

    public void setPassword(String password) {//setters
        this.password = password;
    }

    public  ArrayList<Transaction> getTransaction() {//getters
        return transaction;
    }
}
