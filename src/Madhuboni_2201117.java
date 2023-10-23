import java.util.Scanner;
import java.util.ArrayList;

class Sell{
    int dateOfSell;
    private int itemCode;
    int quantity;
    double totalAmount;
   Sell(){

   }
}
class Return{
    int dateOfReturn;
    private int itemCode;
    int quantity;
    double returnAmount;
    Return(){

    }
}
class Item{
    int itemCode;
    double price;
    int AvailableQty;
    Item(){
         Scanner sc1=new Scanner(System.in);
        System.out.println("enter item code");
        this.itemCode=sc1.nextInt();
        System.out.println("enter item price");
        this.price=sc1.nextInt();
        System.out.println("enter available quatity");
        this.AvailableQty=sc1.nextInt();
    }
    public void addstock(ArrayList<Item> item, Item ib) {
    }
}
class Consumable extends Item{
    int dateofexpiry;
    Consumable(){
        super();
        if(this.itemCode%2!=0){
           System.out.println("not valid code ");
        }
        Scanner sc2=new Scanner(System.in);
        System.out.println("enter date of expiry");
        this.dateofexpiry=sc2.nextInt();
    }
}
class NonConsumable extends Item{
    int returncount;
    NonConsumable(){
        super();
        if(this.itemCode%2==0){
           System.out.println("not valid code ");
        }
        Scanner sc3=new Scanner(System.in);
        System.out.println("enter return count");
        this.returncount=sc3.nextInt();
    }
}

class User{
    String name;
    int dateOfBirth;
    String Address;
    int PAN;
   User(){
        Scanner sc4=new Scanner(System.in);
        System.out.println("enter name");
        this.name=sc4.next();
        System.out.println("enter date of birth");
        this.dateOfBirth=sc4.nextInt();
        System.out.println("enter available quatity");
        this.Address=sc4.next();
   }
}
class SuperUser extends User{
    int SuperUserID;
    int password;
    private int dateOfJoining;
    private double salary;
    String permissibleOperations;
   SuperUser(){
        super();
        Scanner sc5=new Scanner(System.in);
        System.out.println("enter id");
        this.SuperUserID=sc5.nextInt();
        System.out.println("enter password");
        this.password=sc5.nextInt();
        System.out.println("enter date of joining");
        this.dateOfJoining=sc5.nextInt();
        System.out.println("entepermisable operations");
        this.permissibleOperations=sc5.next();
        
   }
   public static void addnewstock(ArrayList<Item> item,Item ob){
        item.add(ob);
    }
    public static void deletestock(ArrayList<Item> item,int i){
        for(Item u:item){
        if(u.itemCode==i){
            item.remove(u);
        }
    }}
    public static void modifystock(ArrayList<Item> item,int i){
        for(Item u:item){
        if(u.itemCode==i){
            Scanner sc6=new Scanner(System.in);
            System.out.println("enter new item price");
            u.price=sc6.nextInt();
             System.out.println("enter new available quatity");
            u.AvailableQty=sc6.nextInt();
        }
        }
    }
}
class NormalUser extends User{
    int userID;
    protected int dateOfJoining;
    protected double salary;
    int dutyHourPerDay;
    NormalUser(){
       super();
       Scanner sc7=new Scanner(System.in);
        System.out.println("enter id");
        this.userID=sc7.nextInt();
        System.out.println("enter date of joining");
        this.dateOfJoining=sc7.nextInt();
        System.out.println("enter salary");
        this.salary=sc7.nextDouble();
        System.out.println("enterr duty hr per day");
        this.dutyHourPerDay=sc7.nextInt();
    
    }
     public static void sellItem (ArrayList<Item> item,int i, int q){
        for(Item u:item){
        if(u.itemCode==i){
            u.AvailableQty=u.AvailableQty-q;
        }
        }
    }
    public static void returnItem (ArrayList<Item> item,int i, int q){
        for(Item u:item){
        if(u.itemCode==i){
            if(u instanceof NonConsumable){
                 System.out.println("non returnable");
            }
            else if(u instanceof Consumable){
                u.AvailableQty=u.AvailableQty+q;
            }
        }
       }
    }
    public static void  displayStock (ArrayList<Item> item,int i){
         for(Item u:item){
        if(u.itemCode==i){
            System.out.println("item price :"+u.price+" available quatity:"+u.AvailableQty);
            if(u instanceof NonConsumable){
                 System.out.println("date of expiry"+u.returncount);
            }
            else if(u instanceof Consumable){
                System.out.println("date of expiry"+u.dateofexpiry);
            }
        }
        }
    }
    

}


public class Madhuboni_2201117 {
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       ArrayList<Item> item=new ArrayList<>();
       char ch='y';
       int c;
       while(ch=='y'){
            System.out.println("1.setup 2.superuser mode 3.normal user mode 4.exit enter your choice");
            c=sc.nextInt();
            switch(c){
                case 1:
                   System.out.println("1.we can make only one super user and many normal users");
                  break;
                case 2:
                   //SUPERUSER MODE
                    SuperUser su=new SuperUser();
                   System.out.println("enter super uder id");
                   int id=sc.nextInt();
                   System.out.println("enter password");
                    int p=sc.nextInt();
                    if(su.SuperUserID==id && su.password==p){
                       System.out.println("1.addstock 2.deletestock 3.modifystock  enter your choice");
                        int c1=sc.nextInt();
                       
                        if(c1==1){
                            System.out.println("1.consumable 2.nonconsumable  enter your choice");
                            int c3=sc.nextInt();
                            if(c3==1){
                              Consumable ib=new Consumable();
                               SuperUser.addnewstock(item,ib);
                            }
                            else if(c3==2){
                                NonConsumable ib=new NonConsumable();
                               SuperUser.addnewstock(item,ib);
                            }
                        }
                        else if(c1==2){
                           System.out.println("enter item code we want to delete");
                            int i=sc.nextInt();
                            SuperUser.deletestock(item,i);
                        }
                        else if(c1==3){
                            System.out.println("enter item code we want to modify");
                            int i=sc.nextInt();
                            SuperUser.modifystock(item,i);
                        }
                    }
                    else{
                        break;
                    }
                   break;
                case 3:
                  //NORMAL USER MODE
                   ArrayList<NormalUser> normal=new ArrayList<>();
                  System.out.println("enter users in normal users array list");
                  char c7='y';
                  while(c7=='y'){
                    NormalUser n=new NormalUser();
                    normal.add(n);
                    System.out.println("do ou want to enter mor eobjects");
                    c7=sc.next().charAt(0);
                  }
                  for(NormalUser n:normal){
                    if(n instanceof NormalUser){
                        System.out.println("1.sellitem 2.return item 3.diaplaystock  enter your choice");
                        int c1=sc.nextInt();
                        Object ib;
                        if(c1==1){
                            System.out.println("enter item code we want to sell");
                            int s=sc.nextInt();
                            System.out.println("enter item quantity");
                            int qu=sc.nextInt();
                            NormalUser.sellItem(item,s,qu);
                        }
                        else if(c1==2){
                           System.out.println("enter item code we want to return");
                            int s=sc.nextInt();
                            System.out.println("enter item quantity");
                            int qu=sc.nextInt();
                            NormalUser.returnItem(item,s,qu);
                        }
                        else if(c1==3){
                           System.out.println("enter item code we want to display");
                            int i=sc.nextInt();
                            NormalUser.displayStock(item,i);
                        }
                    }
                  }
                   break;
                case 4:
                  ch='n';
                  break;
                default:
                  System.out.println("invalid inout");
            }
             System.out.println("do u want to erform more operation");
             ch=sc.next().charAt(0);
       }
    }
}
 
