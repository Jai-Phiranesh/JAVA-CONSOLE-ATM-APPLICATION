public class Transaction {

    private String type;
    private double amount;
    private Object user;

    public Transaction(String type, double amount, Object user) {
        this.type = type;
        this.amount = amount;
        this.user = user;

    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user.toString();
    }

    public double getAmount() {
        return amount;
    }
}
