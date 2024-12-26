
public class Admininfo {
    private  String user = "1";
    private  String pass = "1";
    

    public Admininfo(String u,String p){
        this.user=u;
        this.pass=p;
    }


    Admininfo(){

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
