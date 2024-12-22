import java.util.Scanner;

public class Adminaction {
    static Scanner ob=new Scanner(System.in);
    static Userinfo currentuser;
    public static void login(){
        
        System.out.println("Enter the user name :"); 
        
            String inu=ob.nextLine(); 
            if(inu.equals(Admininfo.getUser())){
                System.out.println("Enter the password :"); 
                String inp=ob.nextLine(); 
                for(int i=0;i<3;i++){
                if(inp.equals(Admininfo.getPass())){
                    
                    Adminaction.operations();
                    return;//verify with nigun na
                }
                else{
                    System.out.println("Wrong pass try again :"); 
                     inp=ob.nextLine(); 
                     if(inp.equals(Admininfo.getPass())){
                        Adminaction.operations();
                        break;
                     
                     
                    
                }
                else if(i==2){
                    System.out.println("TRIES OVER");
                }
            }}

            }
            else{
                System.out.println("Wrong user try again: "); 
            }
            

            
    }

private static void operations(){
    while(true){
    System.out.println("\n1.add user \n2.view all user\n3.deleteuser \n4.view all Transaction\n5.exit:");
    String uc=ob.nextLine();
    int ucho=Integer.parseInt(uc);
    switch (ucho) {
        case 1:
        Adminaction.adduser();
            
            break;
            case 2:
       Adminaction.viewalluser();
            
            break;

            case 3:
            Adminaction.deleteuser();
            break;

            case 4:
            Adminaction.viewalltransaction();
            break ;
            case 5:
            return;
    
        default:
           System.out.println("INVALID input:");
    }}
}



private static void adduser(){
   j: while(true){
    System.out.println("Enter the userid to add or 1 to exit:");


                String inu=ob.nextLine(); 
                if(inu.equals("1")){
                    break j;
                }
                for(Userinfo everyuser:ATM.getArr()){
                    String check=everyuser.getUser();
                    if(inu.equals(check)){
                        System.out.println("user already exits try again:");
                        continue j;
                    }
                }
                
                System.out.println("Enter the password to add:"); 
                
                String inp=ob.nextLine(); 
                Userinfo ub=new Userinfo();
                ub.setUser(inu);
                ub.setPass(inp);
                currentuser=ub;
                ATM.setArr((ub));
                System.out.println("Successfully added the userid and password:"+currentuser.toString());
                break j;
            }          
}


private static void viewalluser(){
    System.out.println("All the users are: "); 
    for(Userinfo everyuser:ATM.getArr()){
    System.out.println(everyuser.getUser());}
               

                }
               

//  private static void deleteuser(){
//      System.out.println("Enter the userid to delete "); 
    
//                  String inu=ob.nextLine(); 
                
//                  for(Userinfo everyuser:ATM.getArr()){
//                     if(everyuser.getUser().equals(inu)){
//                         //int index=ATM.getArr().indexOf(everyuser);
//                         int index=ATM.index(everyuser);
//                         System.out.println("Removed user successfully"+everyuser.getUser());

//                         ATM.getArr().remove(index);
                        
//                     }

//                  }}

                 private static void deleteuser() {
                    System.out.println("Enter the userid to delete:");
                    String inu = ob.nextLine();
                    boolean userFound = false;
                
                    // Use a traditional for loop to avoid concurrent modification issues
                    for (int i = 0; i < ATM.getArr().size(); i++) {
                        Userinfo everyuser = ATM.getArr().get(i);
                        if (everyuser.getUser().equals(inu)) {
                            ATM.userlist.remove(i); // Remove user by index
                            System.out.println("Removed user successfully: " + everyuser.getUser());
                            userFound = true;
                            break;
                        }
                    }
                
                    if (!userFound) {
                        System.out.println("User not found....");
                    }
                }
                
                private static void viewalltransaction(){
                System.out.println("\n1.For specific user \n2.for all user:");
                String uc=ob.nextLine();
                if(uc.equals("1")){
                    System.out.println("Enter the user to view history:");
                    String ucu=ob.nextLine();
                    for(Userinfo everyuser:ATM.getArr()){
                        String check=everyuser.getUser();
                        if(ucu.equals(check)){
                            System.out.println("The Transaction history of: "+ucu);
                            System.out.println(everyuser.getTransaction());
                            
                        }
                        else{
                            System.out.println("ENTER THE CORRECT USERNAME...");
                        }
                    }




                }

                    else if(uc.equals("2")){
                    System.out.println("All the users transactions  are: "); 
                    for(Userinfo everyuser:ATM.getArr()){
                    System.out.println(everyuser.getUser());
                    System.out.println(everyuser.getTransaction());}
                }
                else{
                    System.out.println("INVALID INPUT TRY AGAIN");
                }
                               
                
                                }

               


                
}




