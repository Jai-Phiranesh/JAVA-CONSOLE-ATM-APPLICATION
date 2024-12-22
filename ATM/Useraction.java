import java.util.Scanner;

public class Useraction {
    
    
  
    static Userinfo cub;
    
    static Scanner ob=new Scanner(System.in);
    public static void login(){
        
        System.out.println("Enter the user name: "); 
        
            String inu=ob.nextLine(); 
            for( Userinfo everyuser:ATM.getArr()){
            if(inu.equals(everyuser.getUser())){
                
            
                System.out.println("Enter the password :"); 
                String inp=ob.nextLine(); 
                for(int i=0;i<3;i++){
                if(inp.equals(everyuser.getpass())){
                    cub=everyuser;
                    Useraction.operations();
                    
                    return;
                }
                else{
                    System.out.println("Wrong pass try again :"); 
                     inp=ob.nextLine(); 
                     if(inp.equals(everyuser.getpass())){
                        Useraction.operations();
                       
                        return;
                     
                     
                    
                }
                else if(i==2){
                    System.out.println("TRIES OVER..");
                }
            }}}

            
            else{
                System.out.println("Wrong user try again.. "); 
            }}
            

            
    }
    private static void operations(){
        while(true){
        System.out.println("\n1.check balance \n2.withdrw cash \n3.deposit cash  \n4.changepin\n5.  Transaction\n6.exit:");
        String uc=ob.nextLine();
        int ucho=Integer.parseInt(uc);
        switch (ucho) {
            case 1:
            Useraction.checkbalance();//doubt
                
                break;
                case 2:
                Useraction.withdrawcash();
                
                break;
    
                case 3:
                Useraction.depositcash();
                break;
    
                case 4:
                Useraction.changepin();

                break;
                case 5:
                Useraction.Transaction();
                break;
                case 6:
                return;
                
        
            default:
               System.out.println("INVALID input:");
        }}
    }

private static void checkbalance(){
        System.out.println("YOUR BALANCE IS:"+cub.getBalance());

}
private static void withdrawcash(){
   System.out.println("Enter the amount to with draw:");
   String amount=ob.nextLine();
   double amo=Double.parseDouble(amount);
   if(amo<=cub.getBalance()){
    System.out.println("Amount withdrawn successfully:"+amo);
    double balancef=cub.getBalance();
    balancef-=amo;
    cub.setBalance(balancef);
    System.out.println("Current balance:"+cub.getBalance());
    String trans="Amount withdrawn successfully:"+amo;
    cub.getTransaction().add(trans);
    


   }
   else{
    System.out.println("TRY AGAIN\nAmount withdrawn failed low balnce, \nyour balance "+cub.getBalance()+",YOUR WITHDRAW AMOUNT GIVEN"+amo+"\n deposit amount to with draw:");
   }}



   private static void depositcash(){
    System.out.println("Enter the amount to with deposit:");
    String amount=ob.nextLine();
    double amo=Double.parseDouble(amount);
    
     System.out.println("Amount Deposited  successfully:"+amo);
     double balancef=cub.getBalance();
     balancef+=amo;
     cub.setBalance(balancef);
     System.out.println("Current balance is:"+cub.getBalance());
     String trans="Amount deposited successfully..."+amo;
    cub.getTransaction().add(trans);



 
}

private static void changepin(){
    System.out.println("Enter the password once again to change password:");
    String inp=ob.nextLine(); 
    if(inp.equals(cub.getpass())){
        System.out.println("Enter the New Password:");
        String innp=ob.nextLine(); 
        cub.setPass(innp);
        System.out.println("Password changed successfully..."+innp);


    }
    else{
        System.out.println("Wrong password...");
    }
     
 
}




private static void Transaction(){
    System.out.println("YOUR TRANSACTIONS ARE:");
    System.out.println(cub.getTransaction());
     
 
}


}
