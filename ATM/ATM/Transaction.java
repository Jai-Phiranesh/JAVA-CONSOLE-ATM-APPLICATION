package ATM;
// Class representing a  transaction, storing details like type, amount, and user
public class Transaction {

    private String type;  // Type of the transaction (e.g., deposit, withdrawal)
    private double amount;  // Amount of money  in the transaction
    private String user;  // The user who in the transaction

    // Constructor to initialize a new transaction with type, amount, and user details
    public Transaction(String type, double amount, String user) {
        this.type = type;  // Set the type of transaction
        this.amount = amount;  // Set the transaction amount
        this.user = user;  // Set the user for the transaction
    }

    public String getType() {
        return type;  // Return the type of transaction (e.g., withdraw, deposit)
    }

    public String getUser() {
        return user.toString();  // Return the user details as a string
    }

    public double getAmount() {
        return amount;  // Return the transaction amount
    }
}
