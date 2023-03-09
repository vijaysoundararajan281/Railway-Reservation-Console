package Railway_System;
import java.util.*;
public class rs1 {
    public static Scanner sc = new Scanner(System.in);
    public static int i=0;
    public static int min = 0; 
    public static int max = 100; 
    public static String password[][]=new String[2][15];
    public static int ticket[][]=new int[10][5];
    public static int waitingList[][]=new int [5][5];
    public static String ticketdup[][] = new String[11][6];
    public static String waitingListdup[][] = new String [6][6];
    public static String state[]=new String[10];
    public static String waitstate[] = new String[5];
    public static List<rs1> uList=new ArrayList<>();
    public static List<rs1> uList1=new ArrayList<>();
    
    public static int userid3=0;
    public int userid;
    public String userName;
    public String pass;
    static {
        for(String[] row : ticketdup){
            Arrays.fill(row,"\to");
        }
        for(String[] row : waitingListdup){
            Arrays.fill(row,"\to");
        }
        ticketdup[0][0]="Seat.No";
        ticketdup[0][1]="Coimbatore";
        ticketdup[0][2]="Tirupur";
        ticketdup[0][3]="Erode";
        ticketdup[0][4]="Salem";
        ticketdup[0][5]="Chennai";
        waitingListdup[0][0]="Seat.No";
        waitingListdup[0][1]="Coimbatore";
        waitingListdup[0][2]="Tirupur";
        waitingListdup[0][3]="Erode";
        waitingListdup[0][4]="Salem";
        waitingListdup[0][5]="Chennai";
        ticketdup[1][0]="\t1";ticketdup[2][0]="\t2";ticketdup[3][0]="\t3";ticketdup[4][0]="\t4";ticketdup[5][0]="\t5";ticketdup[6][0]="\t6";ticketdup[7][0]="\t7";ticketdup[8][0]="\t8";ticketdup[9][0]="\t9";ticketdup[10][0]="\t10";
        waitingListdup[1][0]="\t1";waitingListdup[2][0]="\t2";waitingListdup[3][0]="\t3";waitingListdup[4][0]="\t4";waitingListdup[5][0]="\t5";
    }

    public rs1(int userid,String pass) {
        this.userid=userid;
        this.userName=userName;
        this.pass=pass;
       
        
    }

    

    public static void system(){
        
        
        // for(int[] row : ticket){
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println("------------------------------------------------------");
        // for(int[] row : waitingList){
        //     System.out.println(Arrays.toString(row));
        // }
        System.out.println("Welcome to E-Railway Service");
        System.out.println("Login : 1");
        System.out.println("Register : 2");
        int lr=sc.nextInt();
        if(lr==2 && uList.size()==15){
            System.out.println("Sorry ! All tickets are booked");
            system();
        }
        if(lr==2 && uList.size()<15){
            System.out.println("Please enter your name");
            String name1 = sc.next();
            int userid=userid1();
            System.out.println("Please provide password");
            String pass=sc.next();
            System.out.println("Your user-id is "+userid);
            uList.add(new rs1(userid,pass));
            lr=1;
        }
        if(lr==1){
            System.out.println("Please enter your user-id");
            int name = sc.nextInt();
            System.out.println("Please enter your password:");
            String pass1=sc.next();
            int y=0;
            int p=0;
            for(rs1 i:rs1.uList)
            {
            if(i.userid==name){
                if(i.pass.equals(pass1)){
                y++;
                System.out.println("Please select one option :");
                System.out.println("To book tickets : 1");
                System.out.println("To cancel tickets : 2");
                System.out.println("To track the status : 3");
                System.out.println("To Exit : 4");
                int opt=sc.nextInt();
                if (opt==1){
                    book(i.userid,p);
                }
                else if(opt==2){
                    cancel(i.userid,p);
                }
                else if(opt==3){
                    status(i.userid,p);
                }
                else if(opt==4){
                    system();
                }
                else{
                    system();
                }
            
            p++;
                }
                else{
                    System.out.println("Please enter valid-password");
                    system();
                }
        }
        }
    
    
        if(y==0){
            System.out.println("Please enter valid user-id");
            system();
        }
    }
    }
        
    
    public static int userid1(){
        userid3+=1;
        return userid3;
    
    }
    public static void book(int userid,int p){
        System.out.println("\tSeats Availability :");
        for(String[] row : ticketdup){
            System.out.println(Arrays.toString(row));
        }
       System.out.println("Please select the departure Station :"); 
       System.out.println("Coimbatore : 1");
       System.out.println("Tirupur : 2");
       System.out.println("Erode : 3");
       System.out.println("Salem : 4");
       System.out.println("Chennai : 5");
       
       int d=sc.nextInt();
       System.out.println("Please select the Arrival Station :"); 
       if(d==1){
        System.out.println("Tirupur : 2");
        System.out.println("Erode : 3");
        System.out.println("Salem : 4");
        System.out.println("Chennai : 5");
       }
       else if(d==2){
        System.out.println("Erode : 3");
        System.out.println("Salem : 4");
        System.out.println("Chennai : 5");
       }
       else if(d==3){
        System.out.println("Salem : 4");
        System.out.println("Chennai : 5");
       }
       else if(d==4){
        System.out.println("Chennai : 5");
       }
       else{
        system();
       }

       int a=sc.nextInt();
       if(a-d==4){
           Boolean re= booked(d-1,a-2,userid,"F");
           system();
       }
       else if(a-d==3){
        Boolean re=booked(d-1,a-2,userid,"F");
        
        system();
       }
       else if(a-d==2){
        Boolean re=booked(d-1,a-2,userid,"F");
        system();
       }
       else if(a-d==1){
        Boolean re=booked(d-1,a-2,userid,"F");
        system();
        }
        else{
            system();
        }

    }
    public static boolean booked(int d, int a, int userid, String q){
        boolean flag=true;
        for(int i=0;i<10;i++){
            int c=0;
            for(int j=d;j<=a;j++){
                if(ticket[i][j]==0){
                    c++;
                }
            }
            
            if(c==(a-d)+1){
                flag=false;
                for(int j=d;j<=a;j++){
                    ticket[i][j]=userid;
                    ticketdup[i+1][j+1]="\tx";
                }
                if(q=="F"){
                    state[i]="Ticked booked ";
                    return true;
                }
                else if(q=="C"){
                    state[i]="Ticked booked ";
                    return true;
                }
                
                system();
            }
        }
        if(flag ==false && q=="C"){
            return true;
        }
        else if(flag ==true && q=="C"){
            return false;
        }
        if(flag==true && q=="F"){
            System.out.println("Sorry ! All seats are filled");
            System.out.println("\tSeats Availability :");
            for(String[] row : waitingListdup){
                System.out.println(Arrays.toString(row));
            }
            System.out.println("If you want to book tickets in waiting list : 1");
            System.out.println("Exit :2");
            int fr=sc.nextInt();
            
            boolean t=true;
            if(fr==1){
                
            for(int i=0;i<5;i++){
                int c1=0;
                for(int j=d;j<=a;j++){
                if(waitingList[i][j]==0){
                    c1++;
                }
            }
            if(c1==(a-d)+1){
                t=false;
                for(int j=d;j<=a;j++){
                    waitingList[i][j]=userid;
                    waitingListdup[i+1][j+1]="\tx";
                }
                System.out.println("You have been in the Waiting List");
                waitstate[i]="You are in waiting list";
                system();
            }
            }
        }
            else if(fr==2){
                system();
            }
            if(t==true){
                System.out.println("All seats are reserved");
                System.out.println("Sorry!");
                system();
            }
        }
        return flag;
    }
    public static void cancel(int userid,int p){
        
        int c=0;
        System.out.println("Please select one option :");
        System.out.println("If you booked ticked : 1");
        System.out.println("If you are in waiting list : 2");
        int v=sc.nextInt();
        if(v==1){
            int i=0;
            for(i=0;i<10;i++){
                boolean flag =false;
                for(int j=0;j<5;j++){
                    if(ticket[i][j] == userid){
                        c++;
                        flag=true;
                        ticket[i][j]=0;
                        ticketdup[i+1][j+1]="\to";
                    }
                }
                if(flag==true){
                    uList.remove(p);
                    uList1.remove(p);
                    System.out.println("Ticket has Been Canceled");
                    state[i]="";
                    for(int i1=0;i1<5;i1++){
                        int fr=-1;
                        int to=0;;
                        for(int j1=0;j1<5-1;j1++){
                            if(waitingList[i1][j1]!=0){
                                if(waitingList[i1][j1] ==waitingList[i1][j1+1]){
                                    to=j1+1;
                                if(j1==0 && fr==-1){
                                    fr=0;
                                    //fr3=1;
                                }
                                if(j1!=0 && fr==-1 ){
                                    fr=j1;
                                }
                                if(fr==11){
                                    fr=j1;
                                }
                                if(to==3){
                                    int u=waitingList[i1][j1];
                                    boolean rt=booked(fr,to,u,"C");
                                    if(rt){
                                        for(int j2=0;j2<5-1;j2++){
                                            waitingList[i1][j2]=0;
                                            waitingListdup[i1+1][j1+1]="\to";
                                        }
                                        break;
                                    }
                                }
                                
                            }
                            else{
                                int u=waitingList[i1][j1];
                                boolean rt=booked(fr,to, u,"C");
                                if(rt){
                                    for(int j2=0;j2<5-1;j2++){
                                        waitingList[i1][j2]=0;
                                        waitingListdup[i1+1][j1+1]="\to";
                                    }
                                    break;
                                }
                                fr=11;
                            }
                        }
                        }
                    }
                }
            }
            system();
        }
        else if(v==2){
            for(int i=0;i<5;i++){
                boolean flag =false;
                for(int j=0;j<5;j++){
                    if(waitingList[i][j]==userid){
                        ++c;
                        flag=true;
                        waitingList[i][j]=0;
                        waitingListdup[i+1][j+1]="\to";
                    }
                }
                if(flag==true){
                    System.out.println("Ticket has Been Canceled");
                    waitstate[i]="";
                    uList.remove(p);
                    uList1.remove(p);
                    system();
                }
            }
        }
        else{
            system();
        }
    }
    public static void status(int userid,int p){
        
        for(int i=0;i<10;i++){
            for(int j=0;j<5;j++){
                if(ticket[i][j] ==userid){
                    System.out.println(state[i]);
                    break;
                }
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(waitingList[i][j] == userid){
                    System.out.println(waitstate[i]);
                    break;
                }
            }
        }
        system();
    }

    public static void main(String[] args) {
        rs1.system();
    }
}


