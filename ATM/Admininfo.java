
public class Admininfo {//pojo class for admin
    private String user ;  
    private String pass ;  

    // Constructor to initialize admin username and password
    public Admininfo(String u, String p){
        this.user = u;  // Set the admin username
        this.pass = p;  // Set the admin password
    }

    // Default constructor
    Admininfo(){
    }

    
    public String getUser() {
        return user;  // Return the admin username
    }

    
    public String getPass() {
        return pass;  // Return the admin password
    }

    // Override the toString method to return "Admin" as a string(override to string from object class)
    @Override
    public String toString() {
        return "Admin";  // Return the string "Admin"
    }
}
