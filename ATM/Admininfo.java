
public class Admininfo {
    private static String user = "1";
    private static String pass = "1";
    boolean threat=false;

    public void setThreat(boolean threat) {
        this.threat = threat;
    }
    public boolean getThreat(){
        return this.threat;
     }
     

    public  String getUser() {
        return user;
    }

    public  String getPass() {
        return pass;
    }

    @Override

    public String toString() {
        return "Admin";
    }

}
